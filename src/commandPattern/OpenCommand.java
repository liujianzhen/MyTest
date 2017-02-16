package commandPattern;

public class OpenCommand implements Command
{

private Reciver reciver;
	
	public OpenCommand(Reciver reciver)
	{
		this.reciver = reciver;
	}
	
	@Override
	public void execute()
	{
		reciver.open();
	}
}
