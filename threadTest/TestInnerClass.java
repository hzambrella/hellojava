package threadTest;

public class TestInnerClass {
	public static void main(String[] args) {
		//匿名内部类
		Thread t=new Thread(new Runnable(){
			@Override
			public void run() {
				int a=2;
				System.out.println(a>>3);
				a=2;
				Integer a1=new Integer(2);
				Integer a2=new Integer(2);
				System.out.println(a1==a2);//false
				System.out.println(a1==a);//true
			}
		});
		
		t.start();
	}
}
