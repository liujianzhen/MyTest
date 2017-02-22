package thread.communicate.wait;

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
		for (int i = 0; i < 20; i++)
		{
			number.increase();
		}
	}
}
