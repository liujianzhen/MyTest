package thread.communicate.wait;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		NumberHolder number = new NumberHolder();
		NumberHolder1 number1 = new NumberHolder1();
		System.out.println("实现了线程间通信的两个线程：");
		Thread increaseThread = new IncreaseThread(number);
		Thread decreaseThread = new DecreaseThread(number);
		Thread increaseThread1 = new IncreaseThread(number1);
		Thread decreaseThread1 = new DecreaseThread(number1);
		increaseThread.start();
		decreaseThread.start();
		increaseThread.join();
		decreaseThread.join();
		System.out.println("\n没有实现线程间通信的两个线程");
		increaseThread1.start();
		decreaseThread1.start();
	}
}
