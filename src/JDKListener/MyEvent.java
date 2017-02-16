package JDKListener;

import java.util.EventObject;

/**
 * 事件对象
 * 一般封装了事件源对象及跟事件相关的信息
 * @author Administrator
 *EventObject含有事件源及带事件源参数的构造函数
 */
public class MyEvent extends EventObject{

	private static final long serialVersionUID = 1L;

	private EventSource source;
	
	public MyEvent(EventSource source) {
		super(source);
		this.source = source;
	}

	public void setSource(EventSource source) {
		this.source = source;
	}

	@Override
	public EventSource getSource() {
		return this.source;
	}
	
}
