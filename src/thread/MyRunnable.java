package thread;

public class MyRunnable implements Runnable{

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����ִ���̣߳�"+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		System.out.println("���߳����ƣ�"+Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			new Thread(new MyRunnable(),"�߳�"+i).start();
		}
	}
}
