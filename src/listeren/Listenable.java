package listeren;

/**
 * 想要监听事件源，必须实现此接口
 * @author Administrator
 *
 */
public interface Listenable {

	//接口实现者在事件源发生事件时做相应的应对，事件源会将发生的事件传递给监听者
	public void eventChanged(MyEvent e);
}
