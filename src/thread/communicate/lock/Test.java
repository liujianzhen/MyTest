package thread.communicate.lock;
/**
 * 如果是有多个加一和减一的线程，就会出现问题
 * 因为有可能出现一个加一线程完成后唤醒的又是一个加一线程，
 * 而此时该唤醒的加一线程直接往下运行，没有再进行 number 的值的判断，就可能同时加两次。
 * 此时就应该讲 if 改为 while
 * jdk1.5中，提供了多线程的升级解决方案：
 * 将同步synchronized替换为显式的Lock操作，将Object类中的wait(), notify(),notifyAll()替换成了Condition对象，
 * 该对象可以通过Lock锁对象获取; 一个Lock对象上可以绑定多个Condition对象，这样实现了本方线程只唤醒对方线程
 * 见 package thread.communicate.lock
 * @author liujianzhen
 *
 */
public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread[] threads = new Thread[20];
		NumberHolder number = new NumberHolder();
		NumberHolder2 number2 = new NumberHolder2();
		System.out.println("没有考虑多个线程间通信的线程：");
		for (int i = 0; i < 10; i++)
		{
			threads[i] = new IncreaseThread(number);
			threads[i].start();
		}
		for (int i = 10; i < threads.length; i++)
		{
			threads[i] = new DecreaseThread(number);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}
		System.out.println("\n实现了多个线程间通信的线程:");
		for (int i = 0; i < 10; i++)
		{
			new IncreaseThread(number2).start();
			new DecreaseThread(number2).start();
		}
	}
}
