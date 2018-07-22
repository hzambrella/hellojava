package threadTest;

public class TestCondition {
	static Bank bank = new Bank();
	public static void main(String[] args) {

		Thread people1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					bank.transfer(0, 1, 30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread people2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					bank.transfer(1, 0, 30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		people1.start();
		people2.start();
	}
}
