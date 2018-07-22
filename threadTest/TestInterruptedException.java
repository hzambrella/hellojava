package threadTest;

public class TestInterruptedException {
	public static void main(String[] args) {
		TestInterruptedException test=new TestInterruptedException();
		ExamThread ex=test.new ExamThread();
		Thread testThread=new Thread(ex);
		testThread.start();
		try {
			Thread.sleep(1000);
			testThread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class ExamThread implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(100000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
