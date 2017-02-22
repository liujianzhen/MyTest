package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 终点统计仪器
 * @author liujianzhen
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		//每个运动员只要等待一个统计仪器发出起跑信号就可以开跑
		CountDownLatch beginSign = new CountDownLatch(1);
		//统计仪器要等待 8 个运动员到达终点的信号才可以进行结果的统计
		CountDownLatch endSign = new CountDownLatch(8);
		//让 8 位运动员在起点准备好
		for (int i = 0; i < 8; i++)
		{
			new Thread(new Worker(i, beginSign, endSign)).start();
		}
		System.out.println("统计仪器发出起跑信号");
		//统计仪器发出起跑信号
		beginSign.countDown();
		//统计仪器要等待 8 个运动员到达终点的信号
		try
		{
			endSign.await();
			// 8 位运动员都已经到达终点，统计仪器可以进行结果统计和汇报工作了
			System.out.println("8 位运动员都已经到达终点，统计仪器可以进行结果统计和汇报工作了");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
