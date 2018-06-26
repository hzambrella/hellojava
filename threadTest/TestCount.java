package threadTest;

public class TestCount /*implements Runnable*/{
	private int count = 0;

	public int getCount() {
		return count;
	}

/*	public void setCount(int count) {
		this.count = count;
		System.out.println(count);
	}*/
	
/*	public void addCount(){
		int i=this.getCount();	
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		this.setCount(i);
	}*/
	
	public int getNext(){
		return count++;
	}
	
/*
	@Override
	public void run() {
		synchronized(this){
			this.addCount();
		
			System.out.println(this.getCount());
		}			
	}
*/
	public static void main(String[] args) {
		final TestCount tc = new TestCount();
/*		Thread[] threads = new Thread[10];*/
		for (int i = 0; i < 10; i++) {
			String tName = "Thread " + i;
			
		/*	new Thread(tc,tName).start();*/
			new Thread(new Runnable(){
				@Override
				public void run(){
					System.out.println(Thread.currentThread().getName()+"->"+tc.getNext());
					
				}				
			}, tName).start();
		}
		Thread t1=new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName()+"->"+tc.getNext());
				
			}				
		}, "t1");
		
		Thread t2=new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName()+"->"+tc.getNext());
				
			}				
		}, "t2");
		
		t1.start();
		t2.start();
		
		
/*		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}*/
		
/*		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("final:"+tc.getCount());*/
	}

}
