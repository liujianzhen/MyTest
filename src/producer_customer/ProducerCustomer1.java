/**
 * �����tasklist������ringbuffer
 */
package producer_customer;

public class ProducerCustomer1 {
	public static int limit = 10;//���������Ĵ�С
	public static int have = 0;//Ŀǰ����Ҫִ�е����������
	public static int start = 0;//��ǰ��Ҫִ�е�����ָ��
	Task[] tasklist = new Task[limit];//��������

	//������
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
						Task temp = new Task(":��"
										+ (ProducerCustomer1.start + ProducerCustomer1.have)
										% ProducerCustomer1.limit+"������");
						System.out.println(Thread.currentThread().getName()+":��������"+temp.taskname);
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

	//������
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
						System.out.println(Thread.currentThread().getName()+":��������"+temp.taskname);
						temp.doTask();
						//���һ������ָ������ƶ�
						ProducerCustomer1.start = (ProducerCustomer1.start + 1)
								% ProducerCustomer1.limit;
						//����������1
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
		ProducerCustomer1 p = new ProducerCustomer1();
		Producer producer = p.new Producer();
		Customer customer = p.new Customer();
		new Thread(producer,"�������߳�1").start();
		new Thread(producer,"�������߳�2").start();
		new Thread(producer,"�������߳�3").start();
		new Thread(producer,"�������߳�4").start();
		new Thread(customer,"�������߳�1").start();
		new Thread(customer,"�������߳�2").start();
		new Thread(customer,"�������߳�3").start();
		System.out.println("�������ɵ������Ƿ��Ѿ��õ���Ӧ����ɣ����߳̿��Լ���ִ�����������飡");
	}
}
