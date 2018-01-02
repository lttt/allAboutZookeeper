package message;

public interface Request {

	public String getRequestId();

	public void setRequestId(String requestId);

	public String getClassName();

	public void setClassName(String className);

	public String getServiceName();

	public void setServiceName(String serviceName);

	public String getMethodName();

	public void setMethodName(String methodName);

	public Object getRequestObject();

	public void setRequestObject(Object requestObject);

}
