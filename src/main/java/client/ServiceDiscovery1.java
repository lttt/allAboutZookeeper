package client;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import util.Constant;

public class ServiceDiscovery1 {

	private static final Log LOG = LogFactory.getLog(ServiceDiscovery1.class);

	private CountDownLatch latch = new CountDownLatch(1);

	private volatile List<String> dataList = new ArrayList<String>();

	private String registryAddress;

	public ServiceDiscovery1(String registryAddress) {
		this.registryAddress = registryAddress;
		ZooKeeper zk = connectServer();
		if (zk != null) {
			watchNode(zk);
		}
	}

	public String discover() {
		String data = null;
		int size = dataList.size();
		if (size > 0) {
			if (size == 1) {
				data = dataList.get(0);
				LOG.debug(data);
			} else {
				data = dataList.get(ThreadLocalRandom.current().nextInt(size));
				LOG.debug(data);
			}
		}
		return data;
	}

	private ZooKeeper connectServer() {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(registryAddress, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown();
					}
				}
			});
			latch.await();
		} catch (IOException e) {
			LOG.error("", e);
		} catch (InterruptedException e) {
		}
		return zk;
	}

	private void watchNode(final ZooKeeper zk) {
		try {
			List<String> nodeList = zk.getChildren(Constant.ZK_REGISTRY_PATH, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getType() == Event.EventType.NodeChildrenChanged) {
						watchNode(zk);
					}
				}
			});
			List<String> dataList = new ArrayList<String>();
			for (String node : nodeList) {
				byte[] bytes = zk.getData(Constant.ZK_REGISTRY_PATH + "/" + node, false, null);
				dataList.add(new String(bytes));
			}
			LOG.debug(dataList);
			this.dataList = dataList;
		} catch (KeeperException e) {
			LOG.error("", e);
		} catch (InterruptedException e) {
			LOG.error("", e);

		}

	}

}
