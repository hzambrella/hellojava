package threadTest;


//停止不阻塞的线程
public class TestInterruptedWithoutBlock extends Thread {
	boolean stop = false;

	public static void main(String args[]) throws Exception {
		TestInterruptedWithoutBlock thread = new TestInterruptedWithoutBlock();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
//		thread.stop=true; //这里才能停止线程
		thread.interrupt();//这里不能停止线程
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			//每3秒钟打印一次
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
