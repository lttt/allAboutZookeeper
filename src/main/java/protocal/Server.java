package protocal;

import message.Response;

public interface Server {
	
	/**
	 * 开启服务
	 */
	public void start();
	/**
	 * 接受数据
	 * @return
	 */
	public Response revieceData();
	/**
	 * 关闭服务
	 */
	public void shutdown();

}
