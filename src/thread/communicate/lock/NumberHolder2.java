package thread.communicate.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import thread.communicate.Number;

/**
 * ����û��ʵ���̼߳��ͨ��
 * 
 * @author liujianzhen
 *
 */
public class NumberHolder2 implements Number
{
	private int number = 1;

	private Lock lock = new ReentrantLock();
	// �����һ������ Condition ����
	private Condition condition_increase = lock.newCondition();
	// �����һ������ Condition ����
	private Condition condition_decrease = lock.newCondition();

	/**
	 * ���м�һ���� ��ʱ����Ҫ synchronized �ؼ���
	 */
	public void increase()
	{
		// ������������ס�� lock.unlock() ֮��Ĵ��룬��ֹ������һ�����߳�ͬʱ����ô���飬
		lock.lock();
		try
		{
			while (0 != number)
			{
				// ��ʱ�� number ��Ϊ 0�������м�һ��������һ�������߳��� condition_increase �����ϵȴ�
				condition_increase.await();
			}
			// ִ�е�����˵���ٴλ���� condition_increase �Ķ��������� number Ϊ 0
			number++;
			// ִ�����һ�������������ȴ� condition_decrease ���������̣߳�
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
	 * ���м�һ���� ��ʱ����Ҫ synchronized �ؼ���
	 */
	public void decrease()
	{
		// ������������ס�� lock.unlock() ֮��Ĵ��룬��ֹ������һ�����߳�ͬʱ����ô���飬
		lock.lock();
		try
		{
			while (1 != number)
			{
				// ��ʱ�� number ��Ϊ 1�������м�һ��������һ�������߳��� condition_decrease �����ϵȴ�
				condition_decrease.await();
			}
			// ִ�е�����˵���ٴλ���� condition_decrease �Ķ��������� number Ϊ 1
			number--;
			// ִ�����һ�������������ȴ� condition_increase ���������̣߳�
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
