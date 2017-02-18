package decoraterPattern;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("不进行额外的处理，直接打印留言信息！");
		MessageBoard board = new MessageBoard();
		String content = board.handle("hi");
		System.out.println(content);
		
		System.out.println("先过滤敏感信息，再过滤 html 标签");
		content = new HtmlFilter(new SensitiveFilter(new MessageBoard())).handle("hi");
		System.out.println(content);
		
		System.out.println("先过滤 html 标签，再过滤敏感信息");
		content = new SensitiveFilter(new HtmlFilter(new MessageBoard())).handle("hi");
		System.out.println(content);
	}
}
