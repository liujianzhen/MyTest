package thread.communicate.wait;
/**
 * 如果是有多个加一和减一的线程，就会出现问题
 * 因为有可能出现一个加一线程完成后唤醒的又是一个加一线程，
 * 而此时该唤醒的加一线程直接往下运行，没有再进行 number 的值的判断，就可能同时加两次。
 * 此时就应该将 if 改为 while，notify 也要改为 notifyAll
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
		NumberHolder number = new NumberHolder();
		NumberHolder1 number1 = new NumberHolder1();
		System.out.println("实现了线程间通信的两个线程：");
		Thread increaseThread = new IncreaseThread(number);
		Thread decreaseThread = new DecreaseThread(number);
		Thread increaseThread1 = new IncreaseThread(number1);
		Thread decreaseThread1 = new DecreaseThread(number1);
		increaseThread.start();
		decreaseThread.start();
		increaseThread.join();
		decreaseThread.join();
		System.out.println("\n没有实现线程间通信的两个线程");
		increaseThread1.start();
		decreaseThread1.start();
	}
}
