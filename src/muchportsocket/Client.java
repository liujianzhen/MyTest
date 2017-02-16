package muchportsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	/**
	 * 访问的主机
	 */
	private String host;
	/**
	 * 访问的端口
	 */
	private int port;
	
	public Client(String host,int port)
	{
		this.host = host;
		this.port = port;
	}
	
	public void start()
	{
		try
		{
			Socket socket = new Socket(host, port);
			OutputStream ops = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(ops);
			pw.write("hello world!");
			pw.flush();
			socket.shutdownOutput();
			pw.close();
			ops.close();
			socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
