package threadTest;

import java.util.concurrent.atomic.AtomicInteger;


//������
public class TestAdd implements Runnable {

//	public  volatile Integer i=0;
	
	public volatile AtomicInteger i=new AtomicInteger(0);

//  ����ᳬ��1000
//	public void run(){
//		while (i<1000){
//			synchronized(this){  //����������
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
