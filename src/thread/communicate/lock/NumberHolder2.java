package thread.communicate.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import thread.communicate.Number;

/**
 * 此类没有实现线程间的通信
 * 
 * @author liujianzhen
 *
 */
public class NumberHolder2 implements Number
{
	private int number = 1;

	private Lock lock = new ReentrantLock();
	// 代表加一操作的 Condition 对象
	private Condition condition_increase = lock.newCondition();
	// 代表减一操作的 Condition 对象
	private Condition condition_decrease = lock.newCondition();

	/**
	 * 进行加一操作 此时不需要 synchronized 关键字
	 */
	public void increase()
	{
		// 进行上锁，锁住与 lock.unlock() 之间的代码，防止两个加一操作线程同时进入该代码块，
		lock.lock();
		try
		{
			while (0 != number)
			{
				// 此时的 number 不为 0，不进行加一操作，加一操作的线程在 condition_increase 对象上等待
				condition_increase.await();
			}
			// 执行到这里说明再次获得了 condition_increase 的对象锁，且 number 为 0
			number++;
			// 执行完加一操作后唤醒其他等待 condition_decrease 对象锁的线程，
			System.out.print(number + " ");
			condition_decrease.signalAll();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			lock.unlock();
		}
	}

	/**
	 * 进行减一操作 此时不需要 synchronized 关键字
	 */
	public void decrease()
	{
		// 进行上锁，锁住与 lock.unlock() 之间的代码，防止两个加一操作线程同时进入该代码块，
		lock.lock();
		try
		{
			while (1 != number)
			{
				// 此时的 number 不为 1，不进行减一操作，减一操作的线程在 condition_decrease 对象上等待
				condition_decrease.await();
			}
			// 执行到这里说明再次获得了 condition_decrease 的对象锁，且 number 为 1
			number--;
			// 执行完加一操作后唤醒其他等待 condition_increase 对象锁的线程，
			System.out.print(number + " ");
			condition_increase.signalAll();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			lock.unlock();
		}
	}
}
