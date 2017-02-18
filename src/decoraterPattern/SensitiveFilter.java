package decoraterPattern;

/**
 * 过滤敏感信息的装饰器
 * @author liujianzhen
 *
 */
public class SensitiveFilter extends MessageBoardDecorater
{

	public SensitiveFilter(MessageBoardHandler messageBoardHandler)
	{
		super(messageBoardHandler);
	}
	
	public String handle(String str)
	{
		String tmp = super.handle(str);
		return tmp+"(过滤敏感信息后)";
	}
}
