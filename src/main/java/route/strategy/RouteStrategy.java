package route.strategy;

import java.util.Map;

public interface RouteStrategy {
	
	public void setServerMap(Map<String, Integer> serverMap);

	public String getServerAddress();

}
