package util;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

public class TestLock {
	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException
	{
		Exclusivelock lock=new Exclusivelock("myLock");
		lock.lock();
	}

}
