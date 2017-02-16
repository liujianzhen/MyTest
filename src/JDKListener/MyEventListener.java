package JDKListener;

import java.util.EventListener;

/** 
 * 事件监听器，实现java.util.EventListener接口。定义回调方法，将你想要做的事 
 * 放到这个方法下,因为事件源发生相应的事件时会调用这个方法。 
 *
 */ 
public class MyEventListener implements EventListener {

	public void callbackMethod(MyEvent event){
		System.out.println("事件源的value属性发生了变化，此时：value="+event.getSource().getValue());
		System.out.println("监听器取value的10倍值："+event.getSource().getValue()*10);
	}
}
