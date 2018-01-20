package register.bean;

public class ServerInfo {
	private String ip;
	
	private Integer port;
	
	private String znode ;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getZnode() {
		return znode;
	}

	public void setZnode(String znode) {
		this.znode = znode;
	}
}
