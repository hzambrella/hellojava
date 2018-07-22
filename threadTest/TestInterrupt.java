package threadTest;

public class TestInterrupt implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		TestInterrupt test=new TestInterrupt();
		Thread t=new Thread(test);
		t.start();
		Thread.sleep(2000);
		System.out.println("try to interrupt");
		t.interrupt();
		System.out.println("�Ƿ��жϣ�"+t.isInterrupted());
	}
	
	@Override
	public void run(){
		while(true){
			long time=System.currentTimeMillis();
			System.out.println("thread is running....");
			while(System.currentTimeMillis()-time<1000){
			}
			if (Thread.interrupted()){
				//�������Thread.interrupted()��ı��ж�״̬Ϊfalse
				System.out.println("ʲô�������жϣ������ܵ�"+Thread.interrupted());
			}
		}
	}
}
