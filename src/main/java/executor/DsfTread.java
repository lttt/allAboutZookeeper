package executor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.concurrent.Callable;

import message.Request;

public class DsfTread implements Callable {

	private Socket Connection;

	public void setConnection(Socket connection) {
		Connection = connection;
	}

	public Object call() throws Exception {

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(Connection.getInputStream()));
		// StringBuilder sb=new StringBuilder();
		// String s;
		// if((s=in.readLine())!=null)
		// {
		// sb.append(s);
		// }

		ObjectInputStream in = new ObjectInputStream(Connection.getInputStream());
		Request request=(Request)in.readObject();;
		return 
				in.readObject();
	}

}
