package innerClass;

public class Test
{
	public static void main(String[] args)
	{
		/**
		 * 1、测试内部类实现多继承
		 */
		System.out.println("1、测试内部类实现多继承\n");
		Singer singer = new Singer();
		singer.eat();
		singer.sing();
		/**
		 * 2、测试内部类实现区分继承类的方法和需要实现的接口的同名方法
		 */
		System.out.println("\n2、测试内部类实现区分继承类的方法和需要实现的接口的同名方法\n");
		Athlete athlete = new Athlete();
		athlete.go();
		athlete.fastGo();
		/**
		 * 3、测试通过内部类实现树结构的常量定义
		 */
		System.out.println("\n3、测试通过内部类实现树结构的常量定义\n");
		System.out.println(IConstant.BUNDLE.ID);
		System.out.println(IConstant.BUNDLE.NAME);
		System.out.println(IConstant.SERVICE.ID);
		System.out.println(IConstant.SERVICE.NAME);
	}
}
