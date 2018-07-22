package threadTest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCyclicBarrier implements Runnable{
	final static int ThreadNUM=10;//�߳���
	final static int parties=ThreadNUM;//դ����parties���� �ڶ���ʵ���Ϊ6.
	
	//ͻ��դ��ʱִ�еķ�����
	static Runnable barrrierAction1=new Runnable(){
		public void run(){
			System.out.println(Thread.currentThread().getName()+"tripped first barrier");
		}
	};
	static Runnable barrrierAction2=new Runnable(){
		public void run(){
			System.out.println(Thread.currentThread().getName()+"tripped second barrier");
		}
	};
	
	static CyclicBarrier barrier1 =new CyclicBarrier(parties,barrrierAction1);
	static CyclicBarrier barrier2=new CyclicBarrier(parties,barrrierAction2);
	
	
	@Override
	public void run() {
		try {
			Random random=new Random();
			
			int time1=1000+random.nextInt(2000);//1000~3000
			Thread.sleep(time1);
			System.out.println(Thread.currentThread().getName()+":first barrie. num of"+barrier1.getNumberWaiting()+" waiting");
			
			barrier1.await();//��һ��դ��
//			barrier1.await(4,TimeUnit.SECONDS);
			
			int time2=1000+random.nextInt(2000);//1000~3000
			Thread.sleep(time2);
			System.out.println(Thread.currentThread().getName()+":second barrie. num of"+barrier2.getNumberWaiting()+" waiting");
			barrier2.await();//�ڶ���դ��
//			barrier1.await(4,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		for(int i=0;i<ThreadNUM;i++){
			TestCyclicBarrier test=new TestCyclicBarrier();
			Thread t=new Thread(test);
			t.start();
		}
	}
}
