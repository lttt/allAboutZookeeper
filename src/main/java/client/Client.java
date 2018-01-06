package client;

import java.io.IOException;

import message.Request;
import message.Response;

public interface Client {

	/**
	 * 连接服务
	 */
	public void connect(String ip,int port);

	/**
	 * 发送数据
	 * 
	 * @return
	 */
	public Response rpc(Request request);

	/**
	 * 关闭服务
	 * @throws IOException 
	 */
	public void close(String ip) throws IOException;

}
