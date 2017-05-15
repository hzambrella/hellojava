package mashibin.ThreadDeadLock;

//synchronized圈起的代码块，只能由一个线程访问。
//该过程中,其他线程仍然可以访问非synchronized圈起的代码块。
class TT extends Thread{
	int b=100;
	String name;
	
	public TT(String name){
		this.name=name;
	}
	
	public synchronized void m1()throws Exception{
		b=1000;
		Thread.sleep(3000);//执行3秒
		System.out.println("m1() b="+this.name+" "+b);
	}
	
	
	// 修改这里，加上synchronized和去掉的区别
	
	public  void  m2()throws Exception{ //m2 1000 m1 1000 程序运行时间短一些
	//public synchronized  void  m2()throws Exception{// m2 200 m1 1000
													//程序运行时间长一些
		b=200;
		Thread.sleep(2000);
		System.out.println("m2() b="+this.name+" "+b);
	}
	
	public void run(){
		try{
			this.m1();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class ThreadSync {
	public static void main(String[] args)throws Exception{
		TT tt=new TT("t1");
		//TT t2=new TT("t2");
		tt.start();
		//System.out.println("3s.....");
		//tt.m1();
		//tt.m2();
		//System.out.println("3s.....");
		//t2.m1();
		//System.out.println("after 1s");
		//Thread.sleep(1000);//执行主线程1秒，确保是在分线程运行
						   //过程中访问的非synchronized代码块
		tt.m2();//结果1000
		
		
	}
}

