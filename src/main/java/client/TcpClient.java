package client;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import executor.DsfClientTread;
import message.Request;
import message.Response;

public class TcpClient implements Client {

	private Socket socket;

	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.setSoTimeout(15000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Response rpc(Request request) {
		DsfClientTread clientThread = new DsfClientTread();
		clientThread.setRequest(request);
		clientThread.setConnection(socket);
		Object o = null;
		try {
			o = clientThread.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Response)o;

	}

	public void close(String ip) throws IOException {
		if (socket != null) {
			socket.close();

		}

	}

}
