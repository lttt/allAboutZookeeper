package executor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

import message.Request;
import message.Response;

public class NioClientTask implements Callable<Object> {

	private String ip;
	private int port;

	private Request request;

	public void setRequest(Request request) {
		this.request = request;
	}

	public Object call() throws Exception {
		return null;
	}

}
