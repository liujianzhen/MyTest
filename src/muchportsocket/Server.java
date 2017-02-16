package muchportsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread
{
	/**
	 * 服务器名字
	 */
	private String name;
	/**
	 * 监听端口
	 */
	private int port;
	
	public Server(String name,int port )
	{
		this.name = name;
		this.port = port;
	}

	@Override
	public void run()
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = null;
			while (true)
			{
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}		

	}
}
