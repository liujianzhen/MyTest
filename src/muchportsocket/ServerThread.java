package muchportsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread
{
	/**
	 * 获取到的客户端连接
	 */
	private Socket socket;
	
	public ServerThread(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run()
	{
		try
		{
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null)
			{
				System.out.println(info);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
