package ThreadDeadLock;


//接ThreadLock
//synchronized意义， static的意义



//练习3：死锁
public class ThreadDeadLock  extends Thread{
	int flag=0;
	//问题1：没有死锁现象啊!
	//Object o1=new Object();
	//Object o2=new Object();
	
	//上面的两句加上static
	//因为static才会出现资源抢夺
	//由于static 的变量所有的调用都是同一块内存（同一个进程），
	//所以两个线程所需要的变量是一样的，
	//那么这两个变量学名上是临介资源，一次只能给一个进程服务；
	//死锁必须存在一个以上的临介资源，
	//https://zhidao.baidu.com/question/436102483.html

	static Object o1=new Object();
	static Object o2=new Object();
	

	public void run(){
		if (this.flag==1){
			System.out.println("flag:"+this.flag);
			synchronized(o1){
				try {
					Thread.sleep(100);
				}catch (Exception e){
					e.printStackTrace();
				}
				System.out.println("o1");
				
				synchronized(o2){
					System.out.println("o2");
				}
			}
		}//flag==1
		
			if (this.flag==0){
				System.out.println("flag:"+this.flag);
				synchronized(o2){
					try {
						Thread.sleep(2000);
					}catch (Exception e){
						e.printStackTrace();
					}
					System.out.println("o2");
					
					synchronized(o1){
						System.out.println("o1");
					}
				}
			
			
		}//flag==0
	}//run()
	
	public static void main(String[] args){
		ThreadDeadLock t1=new ThreadDeadLock();
		ThreadDeadLock t2=new ThreadDeadLock();
		t1.flag =0;
		t1.flag =1;
		t1.start();
		t2.start();
	}
}//class ThreadDeadLock


