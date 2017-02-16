package listeren;

import java.util.ArrayList;

public class EventSource {

	//事件源的属性
	private int value;
	
	//监听了此事件源的监听者集合
	ArrayList<Listenable> listeners = new ArrayList<Listenable>();
	
	public void addListener(Listenable listener){
		listeners.add(listener);
	}

	public void setValue(int value) {
		this.value = value;
		fireChanged();
	}

	private void fireChanged() {
		MyEvent event = new MyEvent();
		event.setValue(value);
		for (Listenable listenable : listeners) {
			listenable.eventChanged(event);
		}
	}
}
