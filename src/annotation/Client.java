package annotation;
/**
 * ������
 * @author liujianzhen
 *
 */
public class Client {

	public static void main(String[] args) {
		
		try {
			//����Apple��
			Class<?> apple = Class.forName("demo1.Apple");
			
			//��ӡApple���ϵ�ע����Ϣ
			FruitInfoutil.printFruitInfo(apple);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
