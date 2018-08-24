package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
	AtomicInteger number=new AtomicInteger(2);
	
	public static void main(String[] args) {
		TestAtomicInteger test=new TestAtomicInteger();
		AtomicInteger number=test.number;
		
		System.out.println(number.getAndSet(15)+"-"+number);//改变数字.返回的是旧值
		number.lazySet(16);
		System.out.println("lazySet to 16-"+number);//改变数字.返回的是旧值
		 //第一个参数是期望的，期望值和现在值一样时，才能改变。这个叫CAS
		System.out.println(number.compareAndSet(16, 12)+"-"+number);
		//i++差不多
		System.out.println(number.getAndAdd(6)+"-"+number);//加法。返回相加前的结果
		//++i差不多
		System.out.println(number.addAndGet(10)+"-"+number);//加法。返回加法的结果
	}
}
