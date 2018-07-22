package threadTest;

import java.util.concurrent.atomic.AtomicInteger;


//计数器
public class TestAdd implements Runnable {

//	public  volatile Integer i=0;
	
	public volatile AtomicInteger i=new AtomicInteger(0);

//  这个会超出1000
//	public void run(){
//		while (i<1000){
//			synchronized(this){  //不加锁不行
//				i++;
//				System.out.println(i);
//			}
//		}
//	}
	
	public void run(){
		while(i.get()<1000){
			System.out.println(i.getAndIncrement());
		}
	}
	
	
	public static void main(String[] args) {
		int num=20;
//		Thread[] ts=new Thread[num];
		TestAdd ins=new TestAdd();
		for (int i=0;i<num;i++){
			Thread t=new Thread(ins);
			t.start();
		}
	}
}
