package decoraterPattern;

/**
 * 装饰角色
 * 定义一个装饰器最基本的内容
 * @author liujianzhen
 *
 */
public class MessageBoardDecorater implements MessageBoardHandler
{

	private MessageBoardHandler messageBoardHandler;
	
	public MessageBoardDecorater(MessageBoardHandler messageBoardHandler)
	{
		super();
		this.messageBoardHandler = messageBoardHandler;
	}
	
	@Override
	public String handle(String str)
	{
		return messageBoardHandler.handle(str);
	}

}
