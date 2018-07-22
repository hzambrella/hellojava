package threadTest;

//Join的用法
//可以用Future改进。好处是可以取消等待。
public class TestJoin {
	
	public static void main(String[] args) {
		Cooker cooker=new TestJoin().new Cooker();
		Thread tcooker=new Thread(cooker);
		tcooker.start();
	}

	// 厨师做菜。需要厨具，食材，然后做菜。
	// 假设厨师 网购厨具 自己买食材。两者办妥了再做饭
	class Cooker implements Runnable {
		void doCook(Chuju chuju, Shicai shicai) {
			System.out.printf("做菜。。使用厨具%s 做菜%s"+System.lineSeparator(),chuju.getChujuName(),shicai.getShicaiName());
		}

		@Override
		public void run() {
			try {
				//网购厨具
				BuyChuju buyChujuOnline = new BuyChuju();
				Thread buyChujuOnlineThread = new Thread(buyChujuOnline);
				System.out.println("网购厨具");
				long startTime = System.currentTimeMillis();
				buyChujuOnlineThread.start();
				//等快递的同时自己去买菜
				System.out.println("自己去买菜");
				Shicai shicai = new Shicai("佛跳墙");
				buyChujuOnlineThread.join();//等厨具到了才能执行做菜
				//快递到了，菜也买了，开始烧菜
				long endTime = System.currentTimeMillis();
				System.out.println("厨具到了,用时:"+Long.valueOf(endTime-startTime)+"ms");
				doCook(buyChujuOnline.getChuju(), shicai);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	//网购厨具的线程
	class BuyChuju implements Runnable {
		private Chuju chuju;

		@Override
		public void run() {
			try {
				Thread.sleep(4000);
				chuju = new Chuju("哈哈厨具");
				System.out.println("厨具快递到了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public Chuju getChuju() {
			return chuju;
		}
	}

	// 厨具类
	static class Chuju {
		private String chujuName;
		public Chuju(String chujuName) {
			this.chujuName=chujuName;
			System.out.println("厨具生成");
		}
		public String getChujuName() {
			return chujuName;
		}
	}

	// 食材类
	static class Shicai {
		private String shicaiName;
		public Shicai(String shicaiName) {
			try {
				Thread.sleep(400);
				this.shicaiName=shicaiName;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("食材生成");
		}
		public String getShicaiName() {
			return shicaiName;
		}
	}
}
