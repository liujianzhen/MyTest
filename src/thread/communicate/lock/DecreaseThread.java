package thread.communicate.lock;

public class DecreaseThread extends Thread
{
	private Number number;
	
	public DecreaseThread(Number number)
	{
		this.number = number;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			number.decrease();
		}
	}
}
