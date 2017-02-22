package thread.communicate.wait;

/**
 * 此类没有实现线程间的通信
 * 
 * @author liujianzhen
 *
 */
public class NumberHolder1 implements Number
{
	private int number = 1;

	/**
	 * 进行加一操作
	 */
	public synchronized void increase()
	{
		number++;
		System.out.print(number+" ");
	}

	/**
	 * 进行减一操作
	 */
	public synchronized void decrease()
	{
		number--;
		System.out.print(number+" ");
	}
}
