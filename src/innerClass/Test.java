package innerClass;

public class Test
{
	public static void main(String[] args)
	{
		/**
		 * 1�������ڲ���ʵ�ֶ�̳�
		 */
		System.out.println("1�������ڲ���ʵ�ֶ�̳�\n");
		Singer singer = new Singer();
		singer.eat();
		singer.sing();
		/**
		 * 2�������ڲ���ʵ�����ּ̳���ķ�������Ҫʵ�ֵĽӿڵ�ͬ������
		 */
		System.out.println("\n2�������ڲ���ʵ�����ּ̳���ķ�������Ҫʵ�ֵĽӿڵ�ͬ������\n");
		Athlete athlete = new Athlete();
		athlete.go();
		athlete.fastGo();
		/**
		 * 3������ͨ���ڲ���ʵ�����ṹ�ĳ�������
		 */
		System.out.println("\n3������ͨ���ڲ���ʵ�����ṹ�ĳ�������\n");
		System.out.println(IConstant.BUNDLE.ID);
		System.out.println(IConstant.BUNDLE.NAME);
		System.out.println(IConstant.SERVICE.ID);
		System.out.println(IConstant.SERVICE.NAME);
	}
}
