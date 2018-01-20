package register;

import register.bean.ServerInfo;

public interface ServiceRegister {
	
	public ServerInfo registerService(String ip,Integer port);
	
	public void unRegisterService(ServerInfo node);

}
