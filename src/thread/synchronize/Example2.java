/**
 * ͬһ����Ĳ�ͬ���������߳�
 */
package thread.synchronize;

public class Example2 {

	public static void main(String[] args) {
		Thread threadA = new CounterThread(new Counter(),"threadA");
		Thread threadB = new CounterThread(new Counter(),"threadB");
		threadA.start();
		threadB.start();
	}
}
