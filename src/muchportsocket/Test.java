package muchportsocket;

public class Test
{
	public static void main(String[] args)
	{
		Server server1 = new Server("server1", 8888);
		Server server2 = new Server("server2", 9999);
		Client client1 = new Client("localhost", 8888);
		Client client2 = new Client("localhost", 9999);
		server1.start();
		server2.start();
		client1.start();
		client2.start();
	}
}
