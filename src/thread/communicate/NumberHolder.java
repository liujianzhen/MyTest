package thread.communicate;

public class NumberHolder implements Number
{
	private int number = 1;
	
	@Override
	public void increase()
	{
		++number;
		System.out.println(Thread.currentThread().getName()+":"+number);
	}

	@Override
	public void decrease()
	{
		--number;
		System.out.println(Thread.currentThread().getName()+":"+number);
	}

}
