package route.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin implements RouteStrategy{

	private static Integer pos = 0;
	
	private static AtomicInteger count;
	
	private Map<String, Integer> serverMap;

	public  String getServerAddress( ) {
		

		// 取得Ip地址List
		Set<String> keySet = serverMap.keySet();
		ArrayList<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		String server = null;
		boolean isSet=true;
		while(isSet)
		{
			int expect=count.get();
			isSet=count.compareAndSet(expect, expect)	;
		}
		
		synchronized (pos) {
			if (pos > keySet.size())
				pos = 0;
			server = keyList.get(pos);
			pos++;
		}

		return server;
	}

	public void setServerMap(Map<String, Integer> serverMap) {
		this.serverMap=serverMap;
		
	}

	
}