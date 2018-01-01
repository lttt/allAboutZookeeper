package transport;

import message.Message;

public interface ObjectEncoder {
	public Message encode(Object object, Class<?> clz);

}
