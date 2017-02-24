package thread.threadLocal;

import thread.communicate.Number;
/**
 * ����ͨ�� ThreadLocal ������֤�̰߳�ȫ
 * @author liujianzhen
 *
 */
public class NumberHolder3 implements Number
{
	/**
	 * ThreadLocal ά������ʵ�������ڵ�ǰ�̵߳�һ���������̶߳Ըñ��������в������Ƕ���������Ĳ���
	 * ��˾�û�����̰߳�ȫ����
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
