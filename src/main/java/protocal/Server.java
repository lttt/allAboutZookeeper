package protocal;

import message.Message;

public interface Server {
	
	/**
	 * 开启服务
	 */
	public void start();
	/**
	 * 接受数据
	 * @return
	 */
	public Message revieceData();
	/**
	 * 关闭服务
	 */
	public void shutdown();

}
