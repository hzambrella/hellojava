package threadTest;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	final int[] account=new int[]{20,50};//两个人的钱
	private ReentrantLock lock =new ReentrantLock();//锁
	private Condition sufficientFund=lock.newCondition();//条件对象

	public void transfer(int from,int to,int amount) throws InterruptedException{
		lock.lock();
		System.out.println(from+"-->"+to);
		try{
			//钱不足时，等
			while(account[from]<amount){
				sufficientFund.await();//让出锁并阻塞，进入等待池
				System.out.printf("转账失败 用户%d 余额不足\n",from);
			}
			account[from]-=amount;
			account[to]+=amount;
			System.out.printf("用户%d 转%d元给用户%d\n",from,amount,to);
			Thread.sleep(500);
			System.out.println("转账成功"+Arrays.toString(account));
			sufficientFund.signalAll();//通知等待池的其它所有线程争锁
		}finally{
			lock.unlock();
		}
	}
}
