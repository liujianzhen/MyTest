package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 运动员
 * @author liujianzhen
 *
 */
public class Worker implements Runnable
{
	private int id;
	
	//等待统计仪器发出起跑命令的信号
	private CountDownLatch beginSign;
	
	//通知统计仪器该运动员已经到达终点的信号
	private CountDownLatch endSign;
	
	public Worker(int id, CountDownLatch beginSign, CountDownLatch endSign)
	{
		this.id = id;
		this.beginSign = beginSign;
		this.endSign = endSign;
	}

	@Override
	public void run()
	{
		try
		{
			//线程启动后，即运动员在起点准备好后，等待统计仪器发出起跑信号
			beginSign.await();
			//接受到起跑信号开跑
			System.out.println(id+"号运动员开跑");
			Thread.sleep(3*1000);
			//到达终点
			System.out.println(id+"号运动员到达终点");
			//通知统计仪器该运动员已经到达终点
			endSign.countDown();
			//该运动员可以去做其他事情了
			System.out.println(id+"号运动员去做其他事情了");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
