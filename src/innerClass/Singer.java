package innerClass;

/**
 * 这里指会唱歌的人
 * 
 * @author liujianzhen
 *
 */
public class Singer
{
	/**
	 * 内部类继承BasePeople类
	 * @author liujianzhen
	 *
	 */
	private class People extends BasePeople
	{

	}
	/**
	 * 内部类继承BaseSing类
	 * @author liujianzhen
	 *
	 */
	private class Sing extends BaseSing
	{

	}
	/**
	 * 将内部类继承到的方法赋给外围类
	 */
	public void eat()
	{
		new People().eat();
	}
	/**
	 * 将内部类继承到的方法赋给外围类
	 */
	public void sing()
	{
		new Sing().sing();
	}
	
}
