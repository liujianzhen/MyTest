package this_test;

public class Test extends Foo
{
	public static void main(String[] args)
	{
		Foo foo = new Foo();
		Test test = new Test();
		foo.printClassName();
		test.printClassName();
	}
}
