package nio.serverSocketChannel;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));
		FileInputStream fis = new FileInputStream("G:/ifm workspace/Test/src/nio/nio.txt");
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fis.getChannel().read(buffer);
		buffer.flip();
		socketChannel.write(buffer);
	}
}
