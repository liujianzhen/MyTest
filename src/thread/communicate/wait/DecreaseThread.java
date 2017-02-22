package thread.communicate.wait;

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
		for (int i = 0; i < 20; i++)
		{
			number.decrease();
		}
	}
}
