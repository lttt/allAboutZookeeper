package transport;

import message.Request;
import message.Response;

public interface CODEC {
	public byte[] encode(Request request);
	
	public Response decode(byte[] message);

}
