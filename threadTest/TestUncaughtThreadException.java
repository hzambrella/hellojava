package threadTest;

import java.io.FileNotFoundException;
import java.lang.Thread.UncaughtExceptionHandler;

public class TestUncaughtThreadException {
	public static void main(String[] args) {
		TestThread t=new TestThread();
		Thread t1=new Thread(t,"testThread");
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtThreadHandler());//打印结果居然1是main线程！！。
//		t1.setUncaughtExceptionHandler(new MyUncaughtThreadHandler());//如果使用这个，还是System.err。
		if (null==t1.getUncaughtExceptionHandler()){
			System.out.println("空的");
		}else{
			System.out.println(t1.getUncaughtExceptionHandler().getClass().getName());
		}
		
		t1.run();
	}
	
	static class MyUncaughtThreadHandler implements UncaughtExceptionHandler{
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(t.getName()+":"+e.getMessage());
		}
		
	}
	
	static class TestThread implements Runnable{
		@Override
		public void run() {
			throw new RuntimeException("我是不可捕捉异常哈哈");
		}
	}
}
