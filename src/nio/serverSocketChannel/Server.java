package nio.serverSocketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		//配置为非阻塞模式
		serverSocketChannel.configureBlocking(false);
		while(true){
			SocketChannel socketChannel = serverSocketChannel.accept();
			if(socketChannel!=null){
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				socketChannel.read(buffer);
				buffer.flip();
				while(buffer.remaining()>0){
					byte a = buffer.get();
					System.out.println((char)a);
				}
			}
		}
	}
}
