package thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("my first Thread");
	}
	
	public static void main(String[] args) {
		Thread myThread = new MyThread();
		//Ϊʲô������ֱ�ӵ���1)myThread.run()��Ҫ����2)myThread.start()��
			//��Ϊ1)ֻ����ͨ�Ķ�����÷�����main()����Ҫ��run����ִ����ϲ��ܼ�������ִ�У�
			//��2)ֻ���������̣߳�֮������ִ��main()�����������䣬�������߳��Ƿ��Ѿ�ִ����ϣ�
			//
		myThread.start();
	}
}
