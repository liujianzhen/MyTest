package thread.threadLocal;


public class InitialThreadLocal {

	public static class MyRunnable implements Runnable {

        private ThreadLocal<String> threadLocal =new ThreadLocal<String>(){
        	@Override
        	protected String initialValue(){
        		return "This is the inital value";
        	}
        };
        public void run() {
        	String threadExecute = Thread.currentThread().getName()+"ÕýÔÚÖ´ÐÐ£º";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadExecute+"ThreadLocal:"+threadLocal.get());
        }
    }
	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
	}
}
