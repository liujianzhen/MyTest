package thread.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		ServerSocket listener = new ServerSocket(8888);
		Socket socket = null;
		while(true){
			socket = listener.accept();
			Thread serverThread = new ServerThread(socket);
			serverThread.start();
		}
	}
}
