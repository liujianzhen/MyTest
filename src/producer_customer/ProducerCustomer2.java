/**
 * 与ProducerCustomer1完全一样，只是使用lock代替synchronized块
 */
package producer_customer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCustomer2 {
	public static int limit = 10;//任务容器的大小
	public static int have = 0;//目前有需要执行的任务的数量
	public static int start = 0;//当前需要执行的任务指针
	Task[] tasklist = new Task[limit];//任务容器
	private final Lock lock = new ReentrantLock();  
    private final Condition full = lock.newCondition();  
    private final Condition empty = lock.newCondition();  
	//生产者
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
						Task temp = new Task(":第"
										+ (ProducerCustomer2.start + ProducerCustomer2.have)
										% ProducerCustomer2.limit+"个任务");
						System.out.println(Thread.currentThread().getName()+":正在生成"+temp.taskname);
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

	//消费者
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
						System.out.println(Thread.currentThread().getName()+":正在消费"+temp.taskname);
						temp.doTask();
						//完成一个任务，指针向后移动
						ProducerCustomer2.start = (ProducerCustomer2.start + 1)
								% ProducerCustomer2.limit;
						//任务数量减1
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

	//任务
	class Task {
		public String taskname;
		public Task(String taskname) {
			this.taskname = taskname;
		}
		public void doTask(){
			System.out.println("执行任务");
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
		new Thread(producer,"生产者线程1").start();
		new Thread(producer,"生产者线程2").start();
		new Thread(producer,"生产者线程3").start();
		new Thread(producer,"生产者线程4").start();
		new Thread(customer,"消费者线程1").start();
		new Thread(customer,"消费者线程2").start();
		new Thread(customer,"消费者线程3").start();
	}
}
