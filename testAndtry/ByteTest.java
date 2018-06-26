package testAndtry;

import testAndtry.InnerClass.MemberInner;
import testAndtry.InnerClass.StaticInner;


public class ByteTest {
	// 不给final赋值，就在构造函数和非静态代码块赋值
	final int a;
	
	ByteTest(){
		a=1;
		int i = 1;
		int j = 1;
		boolean a=true?true:++i==2?false:true;
		System.out.println("a:"+a+", i:"+i);
		boolean b=false?true:++j==2?false:true;
		System.out.println("b:"+b+", j:"+j);
	}
	
	static class aa{
		
	}
    public static void add(Byte b)
    {
        b = b++;
    }
    public static void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
	public static void main(String[] args) throws InterruptedException{
		test();
		waitForSignal();
	}
	
	
	
	static void waitForSignal() throws InterruptedException
	{
	    Object obj = new Object();
	    synchronized(Thread.currentThread())
	    {
	    	 ((Thread )obj).notify();
				obj.wait();

	      
	    }
	}
}
