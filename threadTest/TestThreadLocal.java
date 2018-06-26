package threadTest;

public class TestThreadLocal {
	private static ThreadLocal<Integer> tl=new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return Integer.valueOf(0);
		}
	};
	
	private static class MyThread implements Runnable{
		private int index;
		public MyThread(int index){
			this.index=index;
			
		}
		
		@Override
		public void run() {
			System.out.println("�߳�" + index + "�ĳ�ʼvalue:" + tl.get());
			for (int i = 0; i < 10; i++) {
                tl.set(tl.get() + i);
            }
            System.out.println("�߳�" + index + "���ۼ�value:" + tl.get());			
		}	
	}
	
	public static void main(String[] args){
		for (int i=0;i<5;i++){
			new Thread(new MyThread(i)).start();
		}
	}
}
