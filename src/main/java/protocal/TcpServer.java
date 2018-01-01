package protocal;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import message.Message;

public class TcpServer implements Server {

	private ServerSocket server;  
	private ExecutorService pool=Executors.newFixedThreadPool(50);

	public void start() {

	}

	public Message revieceData() {
		try {
			Socket socket = server.accept();
			InputStream inputStream = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
