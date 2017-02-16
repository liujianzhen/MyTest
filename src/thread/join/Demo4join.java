package thread.join;

public class Demo4join extends Thread{

	public Demo4join(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"：开始运行");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+"：结束运行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Thread thread1 = new Demo4join("thread1");
		Thread thread2 = new Demo4join("thread2");
		thread1.start();
		System.out.println("主线程：thread1已经启动！");
		thread2.start();
		System.out.println("主线程：thread2已经启动！");
		thread1.join();
		System.out.println("主线程：我必须等thread1执行完成才可以继续往下运行！");
		thread2.join();
		System.out.println("主线程：我必须等thread2执行完成才可以继续往下运行！");
	}
	//其中出现的一种结果
//	主线程：thread1已经启动！
//	thread1：开始运行
//	主线程：thread2已经启动！
//	thread2：开始运行
//	thread1：结束运行
//	主线程：我必须等thread1执行完成才可以继续往下运行！
//	thread2：结束运行
//	主线程：我必须等thread2执行完成才可以继续往下运行！
}
