package threadTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExchangerSimple {
	final Exchanger<Weapon> exchanger=new Exchanger<>();
	final static CountDownLatch counter=new CountDownLatch(2);
	class Weapon{
		private String name;
		Weapon(String name){
			this.name=name;
		}
		
		public String getName(){
			return name;
		}
	}
	
	class Player implements Runnable{
		private String nickName;
		private Weapon weapon;
		
		Player(String nickName,Weapon weapon){
			this.nickName=nickName;
			this.weapon=weapon;
		}
		
		public String getNickName(){
			return nickName;
		}
		
		public String toString(){
			return nickName+"装备："+weapon==null?"空手":weapon.getName();
		}
		
		@Override
		public void run() {
			Weapon weapon2=weapon;
			try {
				Random random=new Random();
				int readyTime=1000+random.nextInt(1000);
				long start=System.currentTimeMillis();
				while(System.currentTimeMillis()-start<readyTime){
				}
				weapon2 = exchanger.exchange(this.weapon);
			} catch (InterruptedException e) {
				System.out.println("交易被中断");
				e.printStackTrace();
			}finally{
				this.weapon=weapon2;
				counter.countDown();//确认交易
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestExchangerSimple test=new TestExchangerSimple();
		ExecutorService pool=Executors.newCachedThreadPool();
		Player player1=test.new Player("player1",test.new Weapon("无尽之刃"));
		Player player2=test.new Player("player2",test.new Weapon("三项之力"));
		pool.execute(new Thread(player1));
		pool.execute(new Thread(player2));
		counter.await();//等待全部交易完成
		pool.shutdown();
		System.out.println(player1);
		System.out.println(player2);
	}
	
}

