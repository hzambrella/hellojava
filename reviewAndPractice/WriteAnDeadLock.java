package reviewAndPractice;

public class WriteAnDeadLock implements Runnable {
	
	boolean flag=false;
	static Object staticLock1=new Object();
	static Object staticLock2=new Object();
	public WriteAnDeadLock(boolean b) {
		this.flag=b;
	}

	@Override
	public void run() {
		if (flag){
			synchronized(staticLock1){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":o1 complete,try to get lock o2");
				
				synchronized(staticLock2){
					System.out.println(Thread.currentThread().getName()+":o2");
				}
			}	
		}else{
			synchronized(staticLock2){
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":o2 complete,try to get lock o1");
				
				synchronized(staticLock1){
					System.out.println(Thread.currentThread().getName()+":o1");
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		WriteAnDeadLock wt1=new WriteAnDeadLock(true);
		WriteAnDeadLock wt2=new WriteAnDeadLock(false);
		Thread t1=new Thread(wt1);
		Thread t2=new Thread(wt2);
		t1.start();
		t2.start();
	}
	
}
