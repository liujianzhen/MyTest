package thread.threadLocal;

import thread.communicate.DecreaseThread;
import thread.communicate.IncreaseThread;
import thread.communicate.Number;
import thread.communicate.NumberHolder;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		Number number = new NumberHolder();
		Number number3 = new NumberHolder3();
		System.out.println("没有考虑线程安全问题：");
		Thread increaseThread = new IncreaseThread(number);
		Thread decreaseThread = new DecreaseThread(number);
		increaseThread.start();
		decreaseThread.start();
		increaseThread.join();
		decreaseThread.join();
		System.out.println("\n通过 ThreadLocal 解决了线程安全问题:");
		new IncreaseThread(number3).start();
		new DecreaseThread(number3).start();
	}
}
