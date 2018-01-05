package client;

import message.Request;

public interface Client {

	/**
	 * 连接服务
	 */
	public void connect(String ip);

	/**
	 * 发送数据
	 * 
	 * @return
	 */
	public void sendData(Request request);

	/**
	 * 关闭服务
	 */
	public void close(String ip);

}
