package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
	AtomicInteger number=new AtomicInteger(2);
	
	public static void main(String[] args) {
		TestAtomicInteger test=new TestAtomicInteger();
		AtomicInteger number=test.number;
		
		System.out.println(number.getAndSet(15)+"-"+number);//�ı�����.���ص��Ǿ�ֵ
		number.lazySet(16);
		System.out.println("lazySet to 16-"+number);//�ı�����.���ص��Ǿ�ֵ
		 //��һ�������������ģ�����ֵ������ֵһ��ʱ�����ܸı䡣�����CAS
		System.out.println(number.compareAndSet(16, 12)+"-"+number);
		//i++���
		System.out.println(number.getAndAdd(6)+"-"+number);//�ӷ����������ǰ�Ľ��
		//++i���
		System.out.println(number.addAndGet(10)+"-"+number);//�ӷ������ؼӷ��Ľ��
	}
}
