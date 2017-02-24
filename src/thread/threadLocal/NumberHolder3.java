package thread.threadLocal;

import thread.communicate.Number;
/**
 * 此类通过 ThreadLocal 类来保证线程安全
 * @author liujianzhen
 *
 */
public class NumberHolder3 implements Number
{
	/**
	 * ThreadLocal 维护的是实例变量在当前线程的一个副本，线程对该变量的所有操作都是对这个副本的操作
	 * 因此就没有了线程安全问题
	 */
	private ThreadLocal<Integer> number = new ThreadLocal<Integer>(){
		@Override
    	protected Integer initialValue(){
    		return 1;
    	}
	};

	@Override 
	public void increase()
	{
		number.set(number.get().intValue()+1);
		System.out.println(Thread.currentThread().getName()+":"+number.get().intValue());
	}

	@Override
	public void decrease()
	{
		number.set(number.get().intValue()-1);
		System.out.println(Thread.currentThread().getName()+":"+number.get().intValue());
	}
}
