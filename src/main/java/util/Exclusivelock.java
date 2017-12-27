package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class Exclusivelock {
	
	private final ZooKeeper zookeeper;
	
	private final CreateMode createMode;
	private final String lockName;
	
	String registryAddress="localhost:2181";
	
	/**
	 * 初始化
	 * @param lockName
	 * @throws IOException
	 * @throws KeeperException
	 * @throws InterruptedException 
	 */
	public Exclusivelock(String lockName) throws IOException, KeeperException, InterruptedException
	{
		zookeeper=new ZooKeeper(registryAddress, Constant.ZK_SESSION_TIMEOUT,null);
		//创建锁根节点
		createMode=CreateMode.fromFlag(3);
		this.lockName="/"+lockName;
			 zookeeper.create(this.lockName, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.fromFlag(0));
	
		
	}
	
	/**
	 * 获取锁
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	public void lock() throws KeeperException, InterruptedException
	{
	
			String lockNode=zookeeper.create(this.lockName+"/lock-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, createMode);
		
			List<String> children=zookeeper.getChildren(this.lockName, null);
			Integer lockSequence=getSequenceFromPath(lockNode);
			for(String lockchild:children)
			{
				Integer childSequence=getSequenceFromPath(lockchild);
				//等待锁
				if(childSequence<lockSequence)
				{
					String watchNode=this.lockName+"/lock-"+Integer.toString(lockSequence-1);
					zookeeper.exists(watchNode, true);
				}
			}


	}
	
	private Integer getSequenceFromPath(String path)
	{
		String[] pieces=path.split("\\_");
		
		Integer sequence=Integer.getInteger(pieces[pieces.length-1]);
		return sequence;
	}
	
	/**
	 * 释放锁
	 */
	public void unlock()
	{
		
	}

}
