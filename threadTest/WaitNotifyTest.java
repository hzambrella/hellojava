package threadTest;

public class WaitNotifyTest {

	// 在多线程间共享的对象上使用wait
	 private String[] shareObj = { "true" };
	 //诡异bug:会抛出IllegalMonitorStateException 
//		private Boolean shareObj =true;
//		private Integer shareObj =1;
//	private String shareObj ="true";

	public static void main(String[] args) {
		WaitNotifyTest test = new WaitNotifyTest();
		ThreadWait threadWait1 = test.new ThreadWait("wait thread1");
		threadWait1.setPriority(2);
		ThreadWait threadWait2 = test.new ThreadWait("wait thread2");
		threadWait2.setPriority(3);
		ThreadWait threadWait3 = test.new ThreadWait("wait thread3");
		threadWait3.setPriority(4);

		ThreadNotify threadNotify = test.new ThreadNotify("notify thread");

		threadWait1.start();
		threadWait2.start();
		threadWait3.start();
		threadNotify.start();
	}

	class ThreadWait extends Thread {

		public ThreadWait(String name) {
			super(name);
		}

		public void run() {
			synchronized (shareObj) {
				//
				while ("true".equals(shareObj[0])) {
//				while (shareObj.equals("true")) {
					System.out.println("线程" + this.getName() + "拿到锁开始做事");
					// System.out.println("线程"+ this.getName() + "开始等待");
					long startTime = System.currentTimeMillis();
					try {
						System.out
								.println("线程" + this.getName() + "放弃了锁，回到了队列");
						shareObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					long endTime = System.currentTimeMillis();
					System.out.println("线程" + this.getName() + "又拿到了锁，等待时间为："
							+ (endTime - startTime));
				}
			}
			System.out.println("线程" + getName() + "运行结束");
		}
	}

	class ThreadNotify extends Thread {

		public ThreadNotify(String name) {
			super(name);
		}

		public void run() {
			try {
				// 给等待线程等待时间
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (shareObj) {
				System.out.println("线程" + this.getName() + "开始准备通知所有线程准备争夺锁");
				shareObj[0] = "false";
//				shareObj = "false";
				shareObj.notifyAll();
				System.out.println("线程" + this.getName() + "通知结束");
			}
			System.out.println("线程" + this.getName() + "运行结束");
		}
	}
}
