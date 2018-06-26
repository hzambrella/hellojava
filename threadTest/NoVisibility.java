package threadTest;

public class NoVisibility {
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready)
				Thread.yield();
			
			System.out.println(number);
			
		}
	}

	
	public static void main(String[] args){
		new ReaderThread().start();

/*		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		number=42;
		ready=true;
	}
}
