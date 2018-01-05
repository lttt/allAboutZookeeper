package executor;


import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.concurrent.Callable;

public class DsfTread implements Callable {

	private Socket Connection;



	public void setConnection(Socket connection) {
		Connection = connection;
	}

	public Object call() throws Exception {
		
			Writer out =new OutputStreamWriter (Connection.getOutputStream());
		
		return null;
	}

}
