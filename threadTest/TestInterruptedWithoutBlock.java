package threadTest;


//ֹͣ���������߳�
public class TestInterruptedWithoutBlock extends Thread {
	boolean stop = false;

	public static void main(String args[]) throws Exception {
		TestInterruptedWithoutBlock thread = new TestInterruptedWithoutBlock();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
//		thread.stop=true; //�������ֹͣ�߳�
		thread.interrupt();//���ﲻ��ֹͣ�߳�
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			//ÿ3���Ӵ�ӡһ��
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
