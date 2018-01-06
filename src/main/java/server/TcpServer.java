package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import executor.DsfServerTread;
import message.Response;

public class TcpServer implements Server {



	private ServerSocket server;  
	private Socket connection;
	private ExecutorService pool=Executors.newFixedThreadPool(50);

	public void start(Integer port)  {
		try {
			server=new ServerSocket(port);
			while(true)
			{
				revieceData(server.accept());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void revieceData(Socket connection){
		try {
			DsfServerTread serverTread=new DsfServerTread();
			serverTread.setConnection(connection);
			serverTread.run();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
