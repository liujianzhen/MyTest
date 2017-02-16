package commandPattern;

import java.util.ArrayList;
import java.util.List;

public class Invoker
{
	private List<Command> commands = new ArrayList<Command>();
	
	/**
	 * 发出命令
	 * @param command
	 */
	public void callCommand(Command command)
	{
		command.execute();
	}
	
	/**
	 * 添加命令
	 */
	public void addCommand(Command command)
	{
		commands.add(command);
	}
	
	/**
	 * 批量执行
	 */
	public void patchExecute()
	{
		for (Command command : commands)
		{
			command.execute();
		}
	}
}
