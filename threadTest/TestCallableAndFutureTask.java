package threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallableAndFutureTask {
	public static void main(String[] args) {
		TestCallableAndFutureTask test=new TestCallableAndFutureTask();
		TestCallable testCallable=test.new TestCallable();
		FutureTask<String>futureTask=new FutureTask<>(testCallable);
		Thread thread=new Thread(futureTask);
		thread.start();
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	class TestCallable implements Callable<String>{
		@Override
		public String call() throws Exception {
			System.out.println("sleeping.....");
			Thread.sleep(1000);
			return "callable future  futureTask!";
		}
		
	}
}
