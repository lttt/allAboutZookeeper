package executor;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DsfTread implements Runnable {

	private Socket connection;

	public Socket getConnection() {
		return connection;
	}

	public void setConnection(Socket connection) {
		this.connection = connection;
	}

	public void run() {
		try {

			InputStream inputStream = connection.getInputStream();
		} catch (IOException e) {

		}

	}

}
