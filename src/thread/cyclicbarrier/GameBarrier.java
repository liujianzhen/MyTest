package thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class GameBarrier
{
	public static void main(String[] args)
	{
		//定义 4 位玩家都完成第一关后要做的事情
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("可以进入第二关");
			}
		});
		for (int i = 0; i < 4; i++)
		{
			new Thread(new Player(i, cyclicBarrier)).start();
		}
	}
}
