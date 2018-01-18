package route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin {

	private static Integer pos = 0;
	
	private static AtomicInteger count;

	public static String getServer() {
		// 重建一个Map，避免服务器的上下线导致的并发问题
		Map<String, Integer> serverMap = new HashMap<String, Integer>();

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
}