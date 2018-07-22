package threadTest;

public class TestInterruptedWithBlock extends Thread {
	boolean stop = false;

	//ֹͣ�������߳�2
	public static void main(String args[]) throws Exception {
		TestInterruptedWithBlock thread = new TestInterruptedWithBlock();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		thread.stop=true;
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			//ÿ3���Ӵ�ӡһ��
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println( "Thread interrupted..." );
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
