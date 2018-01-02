package protocal;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import message.Response;

public class TcpServer implements Server {

	private ServerSocket server;  
	private Socket connection;
	private ExecutorService pool=Executors.newFixedThreadPool(50);

	public void start()  {
		try {
			connection = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Response revieceData() {
		try {
			
			InputStream inputStream = connection.getInputStream();
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
