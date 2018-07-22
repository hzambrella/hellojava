package threadTest;

//Join���÷�
//������Future�Ľ����ô��ǿ���ȡ���ȴ���
public class TestJoin {
	
	public static void main(String[] args) {
		Cooker cooker=new TestJoin().new Cooker();
		Thread tcooker=new Thread(cooker);
		tcooker.start();
	}

	// ��ʦ���ˡ���Ҫ���ߣ�ʳ�ģ�Ȼ�����ˡ�
	// �����ʦ �������� �Լ���ʳ�ġ����߰�����������
	class Cooker implements Runnable {
		void doCook(Chuju chuju, Shicai shicai) {
			System.out.printf("���ˡ���ʹ�ó���%s ����%s"+System.lineSeparator(),chuju.getChujuName(),shicai.getShicaiName());
		}

		@Override
		public void run() {
			try {
				//��������
				BuyChuju buyChujuOnline = new BuyChuju();
				Thread buyChujuOnlineThread = new Thread(buyChujuOnline);
				System.out.println("��������");
				long startTime = System.currentTimeMillis();
				buyChujuOnlineThread.start();
				//�ȿ�ݵ�ͬʱ�Լ�ȥ���
				System.out.println("�Լ�ȥ���");
				Shicai shicai = new Shicai("����ǽ");
				buyChujuOnlineThread.join();//�ȳ��ߵ��˲���ִ������
				//��ݵ��ˣ���Ҳ���ˣ���ʼ�ղ�
				long endTime = System.currentTimeMillis();
				System.out.println("���ߵ���,��ʱ:"+Long.valueOf(endTime-startTime)+"ms");
				doCook(buyChujuOnline.getChuju(), shicai);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	//�������ߵ��߳�
	class BuyChuju implements Runnable {
		private Chuju chuju;

		@Override
		public void run() {
			try {
				Thread.sleep(4000);
				chuju = new Chuju("��������");
				System.out.println("���߿�ݵ���");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public Chuju getChuju() {
			return chuju;
		}
	}

	// ������
	static class Chuju {
		private String chujuName;
		public Chuju(String chujuName) {
			this.chujuName=chujuName;
			System.out.println("��������");
		}
		public String getChujuName() {
			return chujuName;
		}
	}

	// ʳ����
	static class Shicai {
		private String shicaiName;
		public Shicai(String shicaiName) {
			try {
				Thread.sleep(400);
				this.shicaiName=shicaiName;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ʳ������");
		}
		public String getShicaiName() {
			return shicaiName;
		}
	}
}
