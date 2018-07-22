package threadTest;

import java.util.concurrent.TimeUnit;

public class TestTimeUnit{
	public static void main(String[] args) {
		long testTime=9500;//ms
		long now=System.currentTimeMillis();
		//긴냥mill
		long mills=now+TimeUnit.MILLISECONDS.toMillis(testTime);
		System.out.println(mills-now);
		//긴냥취
		long result=TimeUnit.SECONDS.convert(mills-now,TimeUnit.MILLISECONDS);
		System.out.println(result);
	}
}
