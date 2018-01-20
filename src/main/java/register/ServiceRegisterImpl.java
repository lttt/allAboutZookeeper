package register;

import org.apache.zookeeper.ZooKeeper;

import register.bean.ServerInfo;

public class ServiceRegisterImpl implements ServiceRegister {
	
	private ZooKeeper zooKeeper;
	
	

	public ServerInfo registerService(String ip, Integer port) {
		zooKeeper.create("dsf", null, acl, createMode)
		return null;
	}

	public void unRegisterService(ServerInfo node) {
		// TODO Auto-generated method stub

	}
	
}
