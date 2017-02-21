package callbackpattern;
/**
 * 此类的 getMsg() 方法就是和 CSCallback 耦合了
 * @author liujianzhen
 *
 */
public class Server
{
	public void getMsg(CSCallback caller,String msg)
	{
		System.out.println("服务器：接受到客户端发过来的消息为 "+msg);
		try
		{
			Thread.sleep(3*1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("服务器：数据处理成功，返回成功状态 200");
		String status = "200";
		caller.process(status);
	}
}
