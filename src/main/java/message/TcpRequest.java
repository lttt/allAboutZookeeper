package message;

import java.io.Serializable;

public class TcpRequest implements Request, Serializable {
	private String requestId;
	private String className;
	private String serviceName;
	private String methodName;
	private Class<?>[] methogParamTypes;

	public Class<?>[] getMethogParamTypes() {
		return methogParamTypes;
	}

	public void setMethogParamTypes(Class<?>[] methogParamTypes) {
		this.methogParamTypes = methogParamTypes;
	}

	private Object requestObject;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(Object requestObject) {
		this.requestObject = requestObject;
	}
	// TODO 根据反射调用本地借口
}
