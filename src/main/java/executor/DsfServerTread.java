package executor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

import message.Request;
import server.CallNative;

public class DsfServerTread implements Runnable {

	private Socket Connection;

	public void setConnection(Socket connection) {
		Connection = connection;
	}

	public void run() {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(Connection.getInputStream()));
		// StringBuilder sb=new StringBuilder();
		// String s;
		// if((s=in.readLine())!=null)
		// {
		// sb.append(s);
		// }
		try {
			ObjectInputStream in = new ObjectInputStream(Connection.getInputStream());
			Request request = (Request) in.readObject();

			ObjectOutputStream out = new ObjectOutputStream(Connection.getOutputStream());
			out.writeObject(CallNative.callNative(request));
			out.flush();
		} catch (Exception e) {

		}

	}

}
