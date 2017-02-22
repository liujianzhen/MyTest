package thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 玩家
 * @author liujianzhen
 *
 */
public class Player implements Runnable
{
	private int id;
	
	CyclicBarrier cyclicBarrier;
	
	public Player(int id, CyclicBarrier cyclicBarrier)
	{
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println(id+"号玩家正在玩第一关...");
			Thread.sleep(3*1000);
			//该玩家已经完成了第一关等在等待其他玩家完成一期通过第一关
			System.out.println(id+"号玩家已经完成了第一关等在等待其他玩家完成一起通过第一关");
			cyclicBarrier.await();
			//所有玩家都完成了第一关，一起通关进入第二关
			System.out.println(id+"号玩家正在玩第二关...");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}
}
