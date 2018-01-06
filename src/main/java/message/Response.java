package message;

public interface Response {
	public String getRequestId();

	public void setRequestId(String requestId);

	public String getClassName();

	public void setClassName(String className);

	public Object getResponseBody();

	public void setResponseBody(Object responseBody);

}
