package JDKListener;

import java.util.ArrayList;

public class EventSource {

	//事件源的属性
	private int value;
	
	//监听了此事件源的监听者集合
	ArrayList<MyEventListener> listeners = new ArrayList<MyEventListener>();
	
	public void addListener(MyEventListener listener){
		listeners.add(listener);
	}

	public void setValue(int value) {
		this.value = value;
		System.out.println("fireChanged begin");
		fireChanged();
	}
	
	public int getValue() {
		return value;
	}

	private void fireChanged() {
		MyEvent event = new MyEvent(this);
		for (MyEventListener listener : listeners) {
			System.out.println("callbackMethod begin");
			listener.callbackMethod(event);
		}
	}
}
