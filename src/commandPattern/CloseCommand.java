package commandPattern;

public class CloseCommand implements Command
{

	private Reciver reciver;
	
	public CloseCommand(Reciver reciver)
	{
		this.reciver = reciver;
	}
	
	@Override
	public void execute()
	{
		reciver.close();
	}

}
