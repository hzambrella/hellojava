package threadTest;

public class WaitNotifyTest {

	// �ڶ��̼߳乲��Ķ�����ʹ��wait
	 private String[] shareObj = { "true" };
	 //����bug:���׳�IllegalMonitorStateException 
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
					System.out.println("�߳�" + this.getName() + "�õ�����ʼ����");
					// System.out.println("�߳�"+ this.getName() + "��ʼ�ȴ�");
					long startTime = System.currentTimeMillis();
					try {
						System.out
								.println("�߳�" + this.getName() + "�����������ص��˶���");
						shareObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					long endTime = System.currentTimeMillis();
					System.out.println("�߳�" + this.getName() + "���õ��������ȴ�ʱ��Ϊ��"
							+ (endTime - startTime));
				}
			}
			System.out.println("�߳�" + getName() + "���н���");
		}
	}

	class ThreadNotify extends Thread {

		public ThreadNotify(String name) {
			super(name);
		}

		public void run() {
			try {
				// ���ȴ��̵߳ȴ�ʱ��
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (shareObj) {
				System.out.println("�߳�" + this.getName() + "��ʼ׼��֪ͨ�����߳�׼��������");
				shareObj[0] = "false";
//				shareObj = "false";
				shareObj.notifyAll();
				System.out.println("�߳�" + this.getName() + "֪ͨ����");
			}
			System.out.println("�߳�" + this.getName() + "���н���");
		}
	}
}
