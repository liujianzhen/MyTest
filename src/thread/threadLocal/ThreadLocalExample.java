package thread.threadLocal;

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();
        private int a ;
        public void run() {
        	String threadExecute = Thread.currentThread().getName()+"正在执行：";
            threadLocal.set( (int) (Math.random() * 100D) );
            a = (int) (Math.random() * 100D);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadExecute+"普通变量："+a);
            System.out.println(threadExecute+"ThreadLocal:"+threadLocal.get());
        }
    }

    public static void main(String[] args) throws Exception {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
