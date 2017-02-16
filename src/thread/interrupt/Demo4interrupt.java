/**
 * ����״̬�̲߳��ᱻ�ж�
 * Object.wait, Thread.sleep�������᲻�ϵ���ѯ���� interrupted ��־λ������������Ϊtrue�󣬻�ֹͣ�������׳� InterruptedException�쳣��
 */
package thread.interrupt;

class Demo4interrupt extends Thread {
    public static void main(String args[]) throws Exception {
        Demo4interrupt thread = new Demo4interrupt();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        thread.interrupt();// ���ж��ź������ú��ٵ���
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread running...");
            try {
                /*
                 * ����߳�������������ȥ����ж��ź���stop�������� ��thread.interrupt()
                 * ��ʹ�����̴߳������ĵط��׳��쳣���������̴߳�����״̬�����������
                 * �����쳣����� ��Ӧ�Ĵ���
                 */
                Thread.sleep(1000);// �߳�����������߳��յ��жϲ����źŽ��׳��쳣
            } catch (InterruptedException e) {
            	System.out.println("��Ϊ�����������̵߳�interrupt���׳��쳣����������״̬");
                System.out.println("Thread interrupted...");
                /*
                 * ����߳��ڵ��� Object.wait()���������߸���� join() ��sleep()����
                 * ���������裬�����ж�״̬�������
                 */
                System.out.println(this.isInterrupted());// false

                //�в��ж����Լ������������Ҫ�����ж��̣߳�����Ҫ���������ж�λ�����
                //����Ҫ�����õ���
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread exiting under request...");
    }
}
