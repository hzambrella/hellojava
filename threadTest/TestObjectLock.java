package threadTest;

public class TestObjectLock {
	private Integer lock=0;

	
	class ThreadObj implements Runnable{

		@Override
		public void run() {
			synchronized(lock){
				System.out.println(lock);
				lock++;
			}
		}
		
	}
	
	public static void  main(String[] args){
		TestObjectLock t=new TestObjectLock();
		ThreadObj t1o=t.new ThreadObj();
		ThreadObj t2o=t.new ThreadObj();
		ThreadObj t3o=t.new ThreadObj();
		
		Thread t1=new Thread(t1o);
		Thread t2=new Thread(t2o);
		Thread t3=new Thread(t3o);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.lock);	
	}
}
