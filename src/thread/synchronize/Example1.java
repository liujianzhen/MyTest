/**
 * ��ͬһ�����������߳�
 */
package thread.synchronize;

public class Example1 {
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter,"threadA");
		Thread threadB = new CounterThread(counter,"threadB");
		threadA.start();
		threadB.start();
	}
}
