package innerClass;

/**
 * ����ָ�ᳪ�����
 * 
 * @author liujianzhen
 *
 */
public class Singer
{
	/**
	 * �ڲ���̳�BasePeople��
	 * @author liujianzhen
	 *
	 */
	private class People extends BasePeople
	{

	}
	/**
	 * �ڲ���̳�BaseSing��
	 * @author liujianzhen
	 *
	 */
	private class Sing extends BaseSing
	{

	}
	/**
	 * ���ڲ���̳е��ķ���������Χ��
	 */
	public void eat()
	{
		new People().eat();
	}
	/**
	 * ���ڲ���̳е��ķ���������Χ��
	 */
	public void sing()
	{
		new Sing().sing();
	}
	
}
