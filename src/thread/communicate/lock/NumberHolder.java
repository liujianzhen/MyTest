package thread.communicate.lock;
/**
 * ����ʵ�����̼߳��ͨ��
 * @author liujianzhen
 *
 */
public class NumberHolder implements Number
{
	private int number = 1;
	
	/**
	 * ���м�һ����
	 */
	public synchronized void increase()
	{
		if (0 != number)
		{
			try
			{
				//��ʱ�� number ��Ϊ 0�������м�һ���������� NumberHolder �Ķ��������Ӷ����߳̽���ȴ�״̬
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//ִ�е�����˵���ٴλ���� NumberHolder �Ķ��������� number Ϊ 0
		number ++;
		//ִ�����һ�������������ȴ� NumberHolder ���������̣߳��������Ѻ�Ҳֻ�д�ͬ������ִ������
		//�� System.out.print(number);���Ҳִ�����ˣ��˳��˸�ͬ�����������ѵ��̲߳��ܻ�� NumberHolder �Ķ�����
		notifyAll();
		System.out.print(number+" ");
	}
	
	/**
	 * ���м�һ����
	 */
	public synchronized void decrease()
	{
		if (1 != number)
		{
			try
			{
				//��ʱ�� number ��Ϊ 1�������м�һ���������� NumberHolder �Ķ��������Ӷ����߳̽���ȴ�״̬
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//ִ�е�����˵���ٴλ���� NumberHolder �Ķ��������� number Ϊ 1
		number --;
		//ִ�����һ�������������ȴ� NumberHolder ���������̣߳��������Ѻ�Ҳֻ�д�ͬ������ִ������
		//�� System.out.print(number);���Ҳִ�����ˣ��˳��˸�ͬ�����������ѵ��̲߳��ܻ�� NumberHolder �Ķ�����
		notifyAll();
		System.out.print(number+" ");
	}
}