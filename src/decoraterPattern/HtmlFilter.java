package decoraterPattern;

/**
 * 过滤 html 标签的装饰器
 * @author liujianzhen
 *
 */
public class HtmlFilter extends MessageBoardDecorater
{

	public HtmlFilter(MessageBoardHandler messageBoardHandler)
	{
		super(messageBoardHandler);
	}
	
	public String handle(String str)
	{
		String tmp = super.handle(str);
		return tmp+"(过滤 html 标签后)";
	}
}
