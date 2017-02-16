package thread.synchronize;

public class CounterThread extends Thread {

	protected Counter counter = null;
	public CounterThread(Counter counter,String threadName) {
		super(threadName);
		this.counter = counter;
	}
	public void run(){
		String threadExecute = Thread.currentThread().getName()+"����ִ�У�";
		for (int i = 0; i < 10; i++) {
			synchronized (counter) {
				System.out.println(threadExecute+"��ʱcounter��ֵ��"+this.counter.getCount());
				System.out.println(threadExecute+this.counter.getCount()+"+"+i);
				counter.add(i);
				System.out.println(threadExecute+"add()����֮���ֵ��"+this.counter.getCount());
				System.out.println();
			}	
		}
	}
}
