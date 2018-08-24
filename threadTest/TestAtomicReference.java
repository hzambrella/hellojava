package threadTest;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
	public static void main(String[] args) {
		final AtomicReference<Integer> money=new AtomicReference<Integer>();
		// 设置账户初始值小于20，显然这是一个需要被充值的账户
		money.set(19);

		new Thread(){
			public void run(){
				while(true){
					Integer m=money.get();
					if (m>10){
						money.compareAndSet(m, m-10);
						 System.out.println("成功消费10元，余额:"+money.get());
					}else{
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		
		new Thread(){
			public void run(){
				while(true){
					Integer m=money.get();
					if (m<20){
						money.compareAndSet(m, m+20);
						 System.out.println("成功充值20元，余额:"+money.get());
					}else{
						break;
					}
				}
			}
		}.start();
	}
}
