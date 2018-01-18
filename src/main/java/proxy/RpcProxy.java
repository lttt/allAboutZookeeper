package proxy;

import client.TcpClient;
import message.Request;
import message.TcpRequest;

public class RpcProxy  {
	
	private String serviceIp="localhost";
	
	private Integer servicePort=12346;
	
	private TcpClient tcp=new TcpClient();
	
	public Object callService(Object realRequest,String serviceName,String methodName)
	{
		tcp.connect(serviceIp, servicePort);
		Request request=new TcpRequest();
		request.setClassName(realRequest.getClass().getName());
		request.setMethodName(methodName);
		request.setRequestObject(realRequest);
		request.setServiceName(serviceName);
		return tcp.callRomote(request);
	}




}
