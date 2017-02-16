package listeren;

public class Client {

	public static void main(String[] args) {
		
		Listenable listener = new Listener();
		EventSource eventSource = new EventSource();
		
		//向事件源注册监听者
		eventSource.addListener(listener);
		
		//事件源发生事件
		eventSource.setValue(0);
	}
}
