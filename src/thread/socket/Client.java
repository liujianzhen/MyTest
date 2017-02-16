package thread.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Client {

	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost",8888);
		PrintWriter pw = new PrintWriter(client.getOutputStream());
		pw.write("localhost:8080//login?userName=admin&password=admin");
		pw.flush();
		client.shutdownOutput();
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String temp = null;
		while((temp = br.readLine())!=null){
			sb = sb.append(temp);
		}
		client.shutdownInput();
		System.out.println(new Date().toString()+"·þÎñÆ÷ÏìÓ¦£º"+sb);
	}
}
