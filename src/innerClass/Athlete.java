package innerClass;

public class Athlete extends BasePeople
{
	/**
	 * ����ڲ��ཫAthlete��Ҫ�̳е�BasePeople���go������
	 * Ҫʵ�ֵ�IFastGo�ӿڵ�go�������ֿ���
	 * ���ӿڵ�go�������¶���ΪfastGo����
	 * 
	 * ���ֱ���޸�Athlete��BasePeople��go����������Ӱ�쵽�Ѿ��̳��˸����ӿڵ�����
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
