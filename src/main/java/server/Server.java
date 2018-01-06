package server;

import java.net.Socket;

import message.Response;

public interface Server {
	
	/**
	 * 开启服务
	 */
	public void start(Integer port);
	/**
	 * 接受数据
	 * @return
	 */
	public void revieceData(Socket connection);
	/**
	 * 关闭服务
	 */
	public void shutdown();

}
