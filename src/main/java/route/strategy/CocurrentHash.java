package route.strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CocurrentHash implements RouteStrategy {

	private final static int hashCircleSize = Integer.MAX_VALUE;

	private Map<String, Integer> serverMap;

	private IPHashTuple[] iPHashTuples;

	public void setServerMap(Map<String, Integer> serverMap) {
		this.serverMap = serverMap;
		Map<Integer, String> rawServerHashMap = new HashMap<Integer, String>();
		Set<String> ipSets = serverMap.keySet();
		for (String ip : ipSets) {
			rawServerHashMap.put(ip.hashCode(), ip);
		}
		Set<Integer> erverHashSet = rawServerHashMap.keySet();
		Integer[] serverHashArray = (Integer[]) erverHashSet.toArray();
		Arrays.sort(serverHashArray);
		this.iPHashTuples = new IPHashTuple[serverHashArray.length];
		for (int i = 0; i < serverHashArray.length; i++) {
			this.iPHashTuples[i] = new IPHashTuple(rawServerHashMap.get(serverHashArray[i]), serverHashArray[i]);
		}
	}

	public String getServerAddress() {
		String localIp="";
		int localHash=localIp.hashCode();
		String routeIp="";
		for(int i=0;i<iPHashTuples.length;i++)
		{
			if(localHash>= iPHashTuples[i].getHashCode())
			{
				routeIp=  iPHashTuples[i].getIp();
			}
		}

		return routeIp;
	}

	private static class IPHashTuple {
		private String Ip;

		public IPHashTuple(String ip, Integer hashCode) {
			super();
			Ip = ip;
			this.hashCode = hashCode;
		}

		private Integer hashCode;

		public String getIp() {
			return Ip;
		}

		public void setIp(String ip) {
			Ip = ip;
		}

		public Integer getHashCode() {
			return hashCode;
		}

		public void setHashCode(Integer hashCode) {
			this.hashCode = hashCode;
		}
	}

}
