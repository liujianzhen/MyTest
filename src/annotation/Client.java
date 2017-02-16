package annotation;
/**
 * 测试类
 * @author liujianzhen
 *
 */
public class Client {

	public static void main(String[] args) {
		
		try {
			//加载Apple类
			Class<?> apple = Class.forName("demo1.Apple");
			
			//打印Apple类上的注解信息
			FruitInfoutil.printFruitInfo(apple);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
