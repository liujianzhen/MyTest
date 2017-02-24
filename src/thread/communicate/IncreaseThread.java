package thread.communicate;

public class IncreaseThread extends Thread
{
	private Number number;
	
	public IncreaseThread(Number number)
	{
		this.number = number;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			number.increase();
		}
	}
}
