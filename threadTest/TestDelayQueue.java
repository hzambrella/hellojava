package threadTest;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayQueue {

	public class Netizen implements Delayed {
		// ���֤
		private String ID;
		// ����
		private String name;
		// ������ֹʱ��
		private long playTime;

		// �Ƚ����ȼ�,ʱ����̵�����
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

		// ��ȡ����ʱ��,����ʱʱ��
		@Override
		public long getDelay(TimeUnit unit) {
			// ������ֹʱ���ȥ���ڵ�ǰʱ��=ʱ��
			return this.playTime - System.currentTimeMillis();
		}

		public String getName() {
			return name;
		}
	}

	// ����
	public class InternetBar implements Runnable {
		// �������,ʹ����ʱ����
		private DelayQueue<Netizen> dq = new DelayQueue<Netizen>();

		// ����
		public void startPlay(String id, String name, Integer money) {
			// ��ֹʱ��= Ǯ��*ʱ��+��ǰʱ��(1��Ǯ1��)
			Netizen netizen = new Netizen(id, name, 1000 * money
					+ System.currentTimeMillis());
			System.out.println(name + "��ʼ�����Ʒ�......");
			dq.add(netizen);
		}

		// ʱ�䵽�»�
		public void endTime(Netizen netizen) {
			System.out.println(netizen.getName() + "�������,�»�");
		}

		@Override
		public void run() {
			// �߳�,���ÿ����������ʱ��
			while (true) {
				try {
					// ����ʱ�䵽.�����һֱ�ȴ�,ֱ��ȡ�����Ԫ��Ϊֹ
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
		// �½�һ������
		InternetBar internetBar = test.new InternetBar();
		// ����������������
		internetBar.startPlay("001", "����", 3);
		internetBar.startPlay("002", "Ҧ��", 7);
		internetBar.startPlay("003", "����", 5);
		Thread t1 = new Thread(internetBar);
		t1.start();
	}
}
