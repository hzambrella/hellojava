package mashibin.ThreadLock;

//学习线程（1 线程的建立，线程死锁）
//建立线程的两种办法:接口Runnable，继承Thread。
//开启线程:Thread()
//关闭线程(如果是死循环的话，建议用flag)
//如何加一线程锁：方法：synchronized()
//写一个死锁程序


//练习2Timer.add()不加锁的结果



//public class ThreadDeadLock {//practice 1
public class ThreadLock implements Runnable{//practice2:主类也可以Runnable
	Timer ti=new Timer();

	
	
	// practice 2
	public void run(){
		for(;;){
			ti.add(Thread.currentThread().getName());
			//Thread.currentThread().yield();
		}
	}
	

	public static void main(String[] args){
		//练习1：建立线程，开启线程，关闭线程
		practice1();
		//练习2：加锁
		//practice2();
	}	//main
	
	
	
	static void practice1(){
		Runner d=new Runner("thread1");
		Runner d2=new Runner("thread2");
		// 问题2:怎么开启线程？
		Thread t1=new Thread(d);//如果是继承的话，看practice2
		Thread t2=new Thread(d);
		Thread t3=new Thread(d2);
		t1.start();
		t2.start();
		t3.start();
		/*不应该写在这里，写在runnable类
		try{
			Thread.currentThread().sleep(900);//问题：这个Thread怎么理解？答：应该是CPU中的进程。
		}catch(InterruptedException i){
			i.printStackTrace();
		}
		 */	
		boolean flag1=false;
		boolean flag2=false;
		for(;;){
			if(d.getI()>10){
				//现象：大于10时不能立即停止
				System.out.println("d.getI():"+d.getI());
				d.shutdown();
				flag1=true;
			}
			
			
			if(d2.getI()>10){
				System.out.println("d2.getI():"+d2.getI());
				d2.shutdown();
				flag2=true;
			}
			
			if (flag1&&flag2){
			//if (flag1){
				System.out.println("main break");
				break;
			}
		}
		
		System.out.println("t1.isAlive()?:"+t1.isAlive());
		System.out.println("t3.isAlive()?:"+t3.isAlive());
	}//practice1

	////练习2：加锁
	public static void practice2(){
		ThreadLock td=new ThreadLock();
		Thread t1=new Thread(td);
		Thread t2=new Thread(td);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
		
	}//practice2:加锁
	
	public static void practice3(){
	}//practice3//死锁
}//ThreadDeadLock



// 问题1:怎么建立一个线程
class Runner implements Runnable{
	String name;
	//问题3：这个例子，怎么温和地关闭一个线程
	private Boolean flag;
	private int i=1;
	
	public Runner(String name){
		this.name=name;
		this.flag=true;
	}

	public int getI(){
		return this.i;
	}
	
	public void shutdown(){
		this.flag=false;
	}
	
	public void run(){
		
		
		while(this.flag){
			i=i+1;
			
			/*
			try{
				Thread.sleep(100);//问题：这个Thread怎么理解？答：应该是CPU中的进程。
			}catch(InterruptedException i){
				i.printStackTrace();
			}
			*/
			/*
			if(this.i>10){
				this.flag=false;
			}
			*/
			System.out.println("this is thread"+this.name+":"+i+this.flag);
		}
	}
}//class Runner


//---------------练习2---------
//问题1:怎么加锁
class Timer {
	private int number=0;
	
	public void add(String name){
		synchronized(this){//问题1
				this.number++;
				System.out.println(name+":"+this.number);
				try {
					Thread.sleep(900);//问题3，这个Thread怎么理解？
				}catch(InterruptedException i){
					//问题2：如何处理这个异常。
					i.getStackTrace();
				}
		}//synchronized
	}
}//class Timer


/*
 //sysnchornize
Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。

一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

五、以上规则对其它对象锁同样适用.
*/