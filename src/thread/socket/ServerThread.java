package thread.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread{
	
	private Socket socket;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String temp = null;
			while((temp = br.readLine())!=null){
				sb.append(temp+"\n");
			}
			socket.shutdownInput();
			System.out.println(new Date().toString()+"收到客户端的请求：\n"+sb);
			Thread.sleep(2000);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write("HTTP/1.1 200 OK\nConnection: keep-alive\nContent-Encoding: gzip\nContent-Type: text/html\nDate: Sat, 18 Feb 2017 09:47:11 GMT\nServer: Apache\nVary: Accept-Encoding\nTransfer-Encoding: chunked");
			pw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
