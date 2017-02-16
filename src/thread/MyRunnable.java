package thread;

public class MyRunnable implements Runnable{

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("正在执行线程："+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		System.out.println("主线程名称："+Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			new Thread(new MyRunnable(),"线程"+i).start();
		}
	}
}
