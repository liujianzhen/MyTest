package this_test;

public class Foo
{
	private int var;

	public int getVar()
	{
		return var;
	}

	public void setVar(int var)
	{
		this.var = var;
	}

	public void printClassName()
	{
		//这里的this是指当前对象而不是指Foo这个类
		//从控制台的输出结果可知
		new _Print(this).printClassName();
	}

}
