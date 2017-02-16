package innerClass;

public class Athlete extends BasePeople
{
	/**
	 * 这个内部类将Athlete类要继承的BasePeople类的go方法和
	 * 要实现的IFastGo接口的go方法区分开来
	 * 将接口的go方法重新定义为fastGo方法
	 * 
	 * 如果直接修改Athlete或BasePeople的go方法名，会影响到已经继承了该类或接口的子类
	 * @author liujianzhen
	 *
	 */
	private class FastGo implements IFastGo
	{
		@Override
		public void go()
		{
			System.out.println("I can go fast!");
		}
	}
	
	public void fastGo()
	{
		new FastGo().go();
	}
}
