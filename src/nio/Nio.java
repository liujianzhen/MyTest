package nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("G:/eclipseJavaEE/MyTest/src/nio/nio.txt");
		FileChannel fc = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();//��ָ���Ƶ�buffer�ֽ�����Ŀ�ʼλ��
		while(buffer.remaining()>0){
			byte charVar = buffer.get();
			System.out.print(charVar);
			System.out.print("->");
			System.out.println((char)charVar);
		}
		fis.close();
	}
}
