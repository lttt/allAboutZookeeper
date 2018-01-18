package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioTcpServer implements Server {
	ServerSocket server;
	ServerSocketChannel serverchannel;

	public void start(Integer port) {
		try {
			ServerSocketChannel serverchannel=ServerSocketChannel.open();
			server=serverchannel.socket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void revieceData(Socket connection) {
		try {
			SocketChannel socketcannel=serverchannel.accept();
			Selector selector=Selector.open();
			socketcannel.register(selector, SelectionKey.OP_ACCEPT);
			while(true)
			{
				try{
					selector.select();
				}catch(Exception e)
				{
					break;
				}
			}
			
			Set<SelectionKey> readyKeys=selector.selectedKeys();
			
			byte[] rotation=new byte[95*2];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
