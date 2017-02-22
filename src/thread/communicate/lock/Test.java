package thread.communicate.lock;
/**
 * ������ж����һ�ͼ�һ���̣߳��ͻ��������
 * ��Ϊ�п��ܳ���һ����һ�߳���ɺ��ѵ�����һ����һ�̣߳�
 * ����ʱ�û��ѵļ�һ�߳�ֱ���������У�û���ٽ��� number ��ֵ���жϣ��Ϳ���ͬʱ�����Ρ�
 * ��ʱ��Ӧ�ý� if ��Ϊ while
 * jdk1.5�У��ṩ�˶��̵߳��������������
 * ��ͬ��synchronized�滻Ϊ��ʽ��Lock��������Object���е�wait(), notify(),notifyAll()�滻����Condition����
 * �ö������ͨ��Lock�������ȡ; һ��Lock�����Ͽ��԰󶨶��Condition��������ʵ���˱����߳�ֻ���ѶԷ��߳�
 * �� package thread.communicate.lock
 * @author liujianzhen
 *
 */
public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread[] threads = new Thread[20];
		NumberHolder number = new NumberHolder();
		NumberHolder2 number2 = new NumberHolder2();
		System.out.println("û�п��Ƕ���̼߳�ͨ�ŵ��̣߳�");
		for (int i = 0; i < 10; i++)
		{
			threads[i] = new IncreaseThread(number);
			threads[i].start();
		}
		for (int i = 10; i < threads.length; i++)
		{
			threads[i] = new DecreaseThread(number);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}
		System.out.println("\nʵ���˶���̼߳�ͨ�ŵ��߳�:");
		for (int i = 0; i < 10; i++)
		{
			new IncreaseThread(number2).start();
			new DecreaseThread(number2).start();
		}
	}
}
