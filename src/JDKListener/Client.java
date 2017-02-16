package JDKListener;

public class Client {

	public static void main(String[] args) {
		
		MyEventListener listener = new MyEventListener();
		EventSource eventSource = new EventSource();
		
		//为事件源注册监听者
		eventSource.addListener(listener);
		
		//事件源发生事件
		eventSource.setValue(1);
		
	}
}
