package filter;

/**
 * 此类会定义一个回调方法
 * 
 * @author liujianzhen
 *
 */
public class Client implements CSCallback
{

	/**
	 * 该客户端连接到的服务器
	 */
	private Server server;

	public Client(Server server)
	{
		this.server = server;
	}

	//此处 msg 定义为final 是为了防止想要被发送的消息在该方法内被修改，主要是订立多人协作修改次方法中的代码时的契约
	public void sendMsg(final String msg)
	{
		System.out.println("客户端：发送的消息是 "+msg);
		//发送异步消息
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				server.getMsg(Client.this, msg);
			}
		}).start();
		//异步消息发送完成
		System.out.println("客户端：异步消息发送成功");
	}

	@Override
	public void process(String status)
	{
		System.out.println("客户端：服务器返回的状态为 " + status);
	}
}
