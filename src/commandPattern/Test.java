package commandPattern;

public class Test
{
	public static void main(String[] args)
	{
		//模拟文档
		Reciver doc = new Reciver();
		//模拟用户
		Invoker user = new Invoker();
		
		System.out.println("用户打开文档");
		user.callCommand(new OpenCommand(doc));
		
		System.out.println("用户添加了批量任务：打开文档后，再关闭文档");
		user.addCommand(new OpenCommand(doc));
		user.addCommand(new CloseCommand(doc));
		user.patchExecute();
	}
}
