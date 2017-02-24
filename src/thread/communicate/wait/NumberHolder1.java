package thread.communicate.wait;

import thread.communicate.Number;

/**
 * ����û��ʵ���̼߳��ͨ��
 * 
 * @author liujianzhen
 *
 */
public class NumberHolder1 implements Number
{
	private int number = 1;

	/**
	 * ���м�һ����
	 */
	public synchronized void increase()
	{
		number++;
		System.out.print(number+" ");
	}

	/**
	 * ���м�һ����
	 */
	public synchronized void decrease()
	{
		number--;
		System.out.print(number+" ");
	}
}
