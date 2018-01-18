package client;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import executor.ClientExecutor;
import executor.ClientTask;
import message.Request;
import message.Response;

public class TcpClient implements Client {

	private Socket socket;

	private ExecutorService excutor = new ClientExecutor();

	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {

		} catch (IOException e) {

		}
		try {
			socket.setSoTimeout(15000);
		} catch (SocketException e) {

		}

	}

	public Object callRomote(Request request) {

		ClientTask clientTask = new ClientTask();
		clientTask.setRequest(request);
		clientTask.setConnection(socket);
		Object o = null;
		try {
			Future<Object> future = excutor.submit(clientTask);
			o = future.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;

	}

	public void close(String ip) throws IOException {
		if (socket != null) {
			socket.close();

		}

	}

}
