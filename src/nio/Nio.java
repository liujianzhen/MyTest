package nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("G:/ifm workspace/Test/src/nio/nio.txt");
		FileChannel fc = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();//将指针移到buffer字节数组的开始位置
		while(buffer.remaining()>0){
			byte a = buffer.get();
			System.out.print(a);
			System.out.print("->");
			System.out.println((char)a);
		}
		fis.close();
	}
}
