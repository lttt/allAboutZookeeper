package transport;

public interface ObjectDecoder {

	public Object decode(String Message, Class<?> clz);

}
