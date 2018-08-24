package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCASAtomic {
	public AtomicInteger number=new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		TestCASAtomic test=new TestCASAtomic();
		System.out.println(test.number.getAndIncrement());
		System.out.println(test.number.getAndIncrement());

	}
	
}
