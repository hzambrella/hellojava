package threadTest;

public class TestInterrupt implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		TestInterrupt test=new TestInterrupt();
		Thread t=new Thread(test);
		t.start();
		Thread.sleep(2000);
		System.out.println("try to interrupt");
		t.interrupt();
		System.out.println("是否被中断？"+t.isInterrupted());
	}
	
	@Override
	public void run(){
		while(true){
			long time=System.currentTimeMillis();
			System.out.println("thread is running....");
			while(System.currentTimeMillis()-time<1000){
			}
			if (Thread.interrupted()){
				//这个方法Thread.interrupted()会改变中断状态为false
				System.out.println("什么？让我中断？不可能的"+Thread.interrupted());
			}
		}
	}
}
