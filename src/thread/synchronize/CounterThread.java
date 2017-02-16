package thread.synchronize;

public class CounterThread extends Thread {

	protected Counter counter = null;
	public CounterThread(Counter counter,String threadName) {
		super(threadName);
		this.counter = counter;
	}
	public void run(){
		String threadExecute = Thread.currentThread().getName()+"正在执行：";
		for (int i = 0; i < 10; i++) {
			synchronized (counter) {
				System.out.println(threadExecute+"此时counter的值："+this.counter.getCount());
				System.out.println(threadExecute+this.counter.getCount()+"+"+i);
				counter.add(i);
				System.out.println(threadExecute+"add()方法之后的值："+this.counter.getCount());
				System.out.println();
			}	
		}
	}
}
