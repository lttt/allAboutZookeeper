package protocal;

import message.Message;

public interface Client {

	/**
	 * 连接服务
	 */
	public void connect(String ip);

	/**
	 * 接受数据
	 * 
	 * @return
	 */
	public void sendData(Message message);

	/**
	 * 关闭服务
	 */
	public void close(String ip);

}
