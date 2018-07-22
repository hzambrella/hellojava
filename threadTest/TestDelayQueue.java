package threadTest;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayQueue {

	public class Netizen implements Delayed {
		// 身份证
		private String ID;
		// 名字
		private String name;
		// 上网截止时间
		private long playTime;

		// 比较优先级,时间最短的优先
		@Override
		public int compareTo(Delayed o) {
			Netizen netizen = (Netizen) o;
			return this.getDelay(TimeUnit.SECONDS)
					- o.getDelay(TimeUnit.SECONDS) > 0 ? 1 : 0;
		}

		public Netizen(String iD, String name, long playTime) {
			ID = iD;
			this.name = name;
			this.playTime = playTime;
		}

		// 获取上网时长,即延时时长
		@Override
		public long getDelay(TimeUnit unit) {
			// 上网截止时间减去现在当前时间=时长
			return this.playTime - System.currentTimeMillis();
		}

		public String getName() {
			return name;
		}
	}

	// 网吧
	public class InternetBar implements Runnable {
		// 网民队列,使用延时队列
		private DelayQueue<Netizen> dq = new DelayQueue<Netizen>();

		// 上网
		public void startPlay(String id, String name, Integer money) {
			// 截止时间= 钱数*时间+当前时间(1块钱1秒)
			Netizen netizen = new Netizen(id, name, 1000 * money
					+ System.currentTimeMillis());
			System.out.println(name + "开始上网计费......");
			dq.add(netizen);
		}

		// 时间到下机
		public void endTime(Netizen netizen) {
			System.out.println(netizen.getName() + "余额用完,下机");
		}

		@Override
		public void run() {
			// 线程,监控每个网民上网时长
			while (true) {
				try {
					// 除非时间到.否则会一直等待,直到取出这个元素为止
					Netizen netizen = dq.take();
					endTime(netizen);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		TestDelayQueue test=new TestDelayQueue();
		// 新建一个网吧
		InternetBar internetBar = test.new InternetBar();
		// 来了三个网民上网
		internetBar.startPlay("001", "侯征", 3);
		internetBar.startPlay("002", "姚振", 7);
		internetBar.startPlay("003", "何毅", 5);
		Thread t1 = new Thread(internetBar);
		t1.start();
	}
}
