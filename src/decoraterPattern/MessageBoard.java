package decoraterPattern;

/**
 * 具体的留言板
 * @author liujianzhen
 *
 */
public class MessageBoard implements MessageBoardHandler
{
	@Override
	public String handle(String str)
	{
		return "留言板："+str;
	}

}
