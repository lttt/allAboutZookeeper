package executor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import message.Request;
import message.Response;

public class DsfClientTread {

	private Socket Connection;
	
	private Request request;



	public void setRequest(Request request) {
		this.request = request;
	}

	public void setConnection(Socket connection) {
		Connection = connection;
	}

	public Object call() throws Exception {

		

		ObjectOutputStream out = new ObjectOutputStream(Connection.getOutputStream());
		out.writeObject(request);
		out.flush();
		
		ObjectInputStream in = new ObjectInputStream(Connection.getInputStream());
		Response response=(Response)in.readObject();;
		return response.getResponseBody();
		
	}

}
