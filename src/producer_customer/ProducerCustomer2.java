/**
 * ��ProducerCustomer1��ȫһ����ֻ��ʹ��lock����synchronized��
 */
package producer_customer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCustomer2 {
	public static int limit = 10;//���������Ĵ�С
	public static int have = 0;//Ŀǰ����Ҫִ�е����������
	public static int start = 0;//��ǰ��Ҫִ�е�����ָ��
	Task[] tasklist = new Task[limit];//��������
	private final Lock lock = new ReentrantLock();  
    private final Condition full = lock.newCondition();  
    private final Condition empty = lock.newCondition();  
	//������
	class Producer implements Runnable {
		public void run() {
			while (true) {
				lock.lock();
				try{
					if (ProducerCustomer2.have < ProducerCustomer2.limit) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Task temp = new Task(":��"
										+ (ProducerCustomer2.start + ProducerCustomer2.have)
										% ProducerCustomer2.limit+"������");
						System.out.println(Thread.currentThread().getName()+":��������"+temp.taskname);
						tasklist[(ProducerCustomer2.start + ProducerCustomer2.have)
								% ProducerCustomer2.limit] = temp;
						ProducerCustomer2.have++;
						empty.signalAll();
					} else {
						try {
							full.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}finally{
					lock.unlock();
				}
			}

		}
	}

	//������
	class Customer implements Runnable {
		public void run() {
			while (true) {
				Task temp = null;
				lock.lock();
				try {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (ProducerCustomer2.have > 0) {
						temp = tasklist[ProducerCustomer2.start];
						System.out.println(Thread.currentThread().getName()+":��������"+temp.taskname);
						temp.doTask();
						//���һ������ָ������ƶ�
						ProducerCustomer2.start = (ProducerCustomer2.start + 1)
								% ProducerCustomer2.limit;
						//����������1
						ProducerCustomer2.have--;
						full.signalAll();
					} else {
						try {
							empty.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}finally{
					lock.unlock();
				}
			}
		}
	}

	//����
	class Task {
		public String taskname;
		public Task(String taskname) {
			this.taskname = taskname;
		}
		public void doTask(){
			System.out.println("ִ������");
			int i = 0;
			while(i < 1000){
				i++;
			}
		}
	}
	public static void main(String[] args) {
		ProducerCustomer2 p = new ProducerCustomer2();
		Producer producer = p.new Producer();
		Customer customer = p.new Customer();
		new Thread(producer,"�������߳�1").start();
		new Thread(producer,"�������߳�2").start();
		new Thread(producer,"�������߳�3").start();
		new Thread(producer,"�������߳�4").start();
		new Thread(customer,"�������߳�1").start();
		new Thread(customer,"�������߳�2").start();
		new Thread(customer,"�������߳�3").start();
	}
}
