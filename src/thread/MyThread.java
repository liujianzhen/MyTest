package thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("my first Thread");
	}
	
	public static void main(String[] args) {
		Thread myThread = new MyThread();
		//为什么不可以直接调用1)myThread.run()而要调用2)myThread.start()？
			//因为1)只是普通的对象调用方法，main()函数要等run方法执行完毕才能继续往下执行；
			//而2)只负责启动线程，之后立马执行main()函数后面的语句，而不管线程是否已经执行完毕；
			//
		myThread.start();
	}
}
