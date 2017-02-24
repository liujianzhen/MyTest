package thread.communicate.wait;

import thread.communicate.Number;
/**
 * 此类实现了线程间的通信
 * @author liujianzhen
 *
 */
public class NumberHolder implements Number
{
	private int number = 1;
	
	/**
	 * 进行加一操作
	 */
	public synchronized void increase()
	{
		if (0 != number)
		{
			try
			{
				//此时的 number 不为 0，不进行加一操作，放弃 NumberHolder 的对象锁，从而该线程进入等待状态
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//执行到这里说明再次获得了 NumberHolder 的对象锁，且 number 为 0
		number ++;
		//执行完加一操作后唤醒其他等待 NumberHolder 对象锁的线程，不过唤醒后也只有此同步方法执行完了
		//即 System.out.print(number);语句也执行完了，退出了该同步方法，唤醒的线程才能获得 NumberHolder 的对象锁
		notify();
		System.out.print(number+" ");
	}
	
	/**
	 * 进行减一操作
	 */
	public synchronized void decrease()
	{
		if (1 != number)
		{
			try
			{
				//此时的 number 不为 1，不进行减一操作，放弃 NumberHolder 的对象锁，从而该线程进入等待状态
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//执行到这里说明再次获得了 NumberHolder 的对象锁，且 number 为 1
		number --;
		//执行完加一操作后唤醒其他等待 NumberHolder 对象锁的线程，不过唤醒后也只有此同步方法执行完了
		//即 System.out.print(number);语句也执行完了，退出了该同步方法，唤醒的线程才能获得 NumberHolder 的对象锁
		notify();
		System.out.print(number+" ");
	}
}
