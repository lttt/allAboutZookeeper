package transport;

import message.Message;

public interface ObjectDecoder {

	public Object decode(Message message, Class<?> clz);

}
