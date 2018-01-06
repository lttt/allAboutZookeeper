package server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import message.Request;
import message.Response;
import message.TcpResponse;

public class CallNative {
	public static Response callNative(Request request) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		String serviceName = request.getServiceName();
		String methodName = request.getMethodName();
		Class<?> serviceClass = Class.forName(serviceName);

		Method method = serviceClass.getDeclaredMethod(methodName,java.lang.String.class);
		Object object = method.invoke(serviceClass.newInstance(), request.getRequestObject());
		Response response = new TcpResponse();
		response.setClassName(method.getReturnType().getName());
		response.setRequestId(request.getRequestId());
		response.setResponseBody(object);
		return response;
	}
}
