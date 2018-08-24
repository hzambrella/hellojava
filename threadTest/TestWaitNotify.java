package threadTest;

import java.util.ArrayList;

public class TestWaitNotify {
	
	class Storage{
		private static final int MAX_SIZE=100;
		private ArrayList<String>list=new ArrayList<>();
		
		public void product() throws InterruptedException{
			synchronized(list){
				//不要用if!!!!!!  数组越界！！！！
				while (list.size()>MAX_SIZE){
					list.wait();
				}
				Thread t=Thread.currentThread();
				list.add(t.getName()+"-"+String.valueOf(System.currentTimeMillis()));
				list.notifyAll();
			}
		}
		
		
		public void consume() throws InterruptedException{
			synchronized(list){
				//不要用if!!!!!! 数组越界！！！！
				while(list.size()<=0){
					list.wait();
				}
				Thread t=Thread.currentThread();
				String p=list.remove(0);
				System.out.printf("消费者%s 消费了 %s \n",t.getName(),
						p);
				list.notifyAll();
			}
		}
	}
	
	class Productor implements Runnable{
		Storage store;
		Productor(Storage store){
			this.store=store;
		}
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(200);
					store.product();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class Consumer implements Runnable{
		Storage store;
		Consumer(Storage store){
			this.store=store;
		}
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(500);
					store.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TestWaitNotify test=new TestWaitNotify();
		Storage store=test.new Storage();
		
		for (int i=0;i<10;i++){
			new Thread(test.new Productor(store),"product"+String.valueOf(i)).start();
		}
		
		
		for (int i=0;i<30;i++){
			new Thread(test.new Consumer(store),"consumer"+String.valueOf(i)).start();
		}
	}
}
