package thread.join;

public class Demo4join extends Thread{

	public Demo4join(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"����ʼ����");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+"����������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Thread thread1 = new Demo4join("thread1");
		Thread thread2 = new Demo4join("thread2");
		thread1.start();
		System.out.println("���̣߳�thread1�Ѿ�������");
		thread2.start();
		System.out.println("���̣߳�thread2�Ѿ�������");
		thread1.join();
		System.out.println("���̣߳��ұ����thread1ִ����ɲſ��Լ����������У�");
		thread2.join();
		System.out.println("���̣߳��ұ����thread2ִ����ɲſ��Լ����������У�");
	}
	//���г��ֵ�һ�ֽ��
//	���̣߳�thread1�Ѿ�������
//	thread1����ʼ����
//	���̣߳�thread2�Ѿ�������
//	thread2����ʼ����
//	thread1����������
//	���̣߳��ұ����thread1ִ����ɲſ��Լ����������У�
//	thread2����������
//	���̣߳��ұ����thread2ִ����ɲſ��Լ����������У�
}
