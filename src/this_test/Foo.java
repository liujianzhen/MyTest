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
		//�����this��ָ��ǰ���������ָFoo�����
		//�ӿ���̨����������֪
		new _Print(this).printClassName();
	}

}
