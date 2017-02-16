/**
 * 这里的tasklist类似于ringbuffer
 */
package producer_customer;

public class ProducerCustomer1 {
	public static int limit = 10;//任务容器的大小
	public static int have = 0;//目前有需要执行的任务的数量
	public static int start = 0;//当前需要执行的任务指针
	Task[] tasklist = new Task[limit];//任务容器

	//生产者
	class Producer implements Runnable {
		public void run() {
			while (true) {
				synchronized (tasklist) {
					if (ProducerCustomer1.have < ProducerCustomer1.limit) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Task temp = new Task(":第"
										+ (ProducerCustomer1.start + ProducerCustomer1.have)
										% ProducerCustomer1.limit+"个任务");
						System.out.println(Thread.currentThread().getName()+":正在生成"+temp.taskname);
						tasklist[(ProducerCustomer1.start + ProducerCustomer1.have)
								% ProducerCustomer1.limit] = temp;
						ProducerCustomer1.have++;
						tasklist.notifyAll();
					} else {
						try {
							tasklist.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
	}

	//消费者
	class Customer implements Runnable {
		public void run() {
			while (true) {
				Task temp = null;
				synchronized (tasklist) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (ProducerCustomer1.have > 0) {
						temp = tasklist[ProducerCustomer1.start];
						System.out.println(Thread.currentThread().getName()+":正在消费"+temp.taskname);
						temp.doTask();
						//完成一个任务，指针向后移动
						ProducerCustomer1.start = (ProducerCustomer1.start + 1)
								% ProducerCustomer1.limit;
						//任务数量减1
						ProducerCustomer1.have--;
						tasklist.notifyAll();
					} else {
						try {
							tasklist.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

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
		ProducerCustomer1 p = new ProducerCustomer1();
		Producer producer = p.new Producer();
		Customer customer = p.new Customer();
		new Thread(producer,"生产者线程1").start();
		new Thread(producer,"生产者线程2").start();
		new Thread(producer,"生产者线程3").start();
		new Thread(producer,"生产者线程4").start();
		new Thread(customer,"消费者线程1").start();
		new Thread(customer,"消费者线程2").start();
		new Thread(customer,"消费者线程3").start();
		System.out.println("不管生成的任务是否已经得到响应并完成，主线程可以继续执行其他的事情！");
	}
}
