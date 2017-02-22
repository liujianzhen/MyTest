package thread.communicate.wait;
/**
 * ������ж����һ�ͼ�һ���̣߳��ͻ��������
 * ��Ϊ�п��ܳ���һ����һ�߳���ɺ��ѵ�����һ����һ�̣߳�
 * ����ʱ�û��ѵļ�һ�߳�ֱ���������У�û���ٽ��� number ��ֵ���жϣ��Ϳ���ͬʱ�����Ρ�
 * ��ʱ��Ӧ�ý� if ��Ϊ while��notify ҲҪ��Ϊ notifyAll
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
		NumberHolder number = new NumberHolder();
		NumberHolder1 number1 = new NumberHolder1();
		System.out.println("ʵ�����̼߳�ͨ�ŵ������̣߳�");
		Thread increaseThread = new IncreaseThread(number);
		Thread decreaseThread = new DecreaseThread(number);
		Thread increaseThread1 = new IncreaseThread(number1);
		Thread decreaseThread1 = new DecreaseThread(number1);
		increaseThread.start();
		decreaseThread.start();
		increaseThread.join();
		decreaseThread.join();
		System.out.println("\nû��ʵ���̼߳�ͨ�ŵ������߳�");
		increaseThread1.start();
		decreaseThread1.start();
	}
}
