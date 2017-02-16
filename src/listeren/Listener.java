package listeren;

public class Listener implements Listenable {

	@Override
	public void eventChanged(MyEvent e) {
		System.out.println("发生了事件："+e+"，其原属性为"+e.getValue());
		System.out.println("进行+1操作得到："+(e.getValue()+1));
	}

}
