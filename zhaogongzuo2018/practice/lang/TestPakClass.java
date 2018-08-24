package zhaogongzuo2018.practice.lang;

public class TestPakClass {
	public static void main(String[] args) {
		testBooleana();
		testInteger();
	}
	
	static void testBooleana(){
		Boolean b1=new Boolean(true);
		Boolean b2=new Boolean(true);
		System.out.println(b1==b2);//类，地址比较
		System.out.println(b1.booleanValue()==b2.booleanValue());//boolean基本类型比较
	}
	
	static void testByte(){
		Byte b=new Byte((byte)1);
	}
	
	static void testDouble(){
		Double d=new Double(1);
	}
	
	static void testInteger(){
		Integer i16=new Integer(0x31);
		Integer i8=new Integer(027);
		System.out.println(i16+"-"+i8);
		System.out.println(Integer.toHexString(i16));//32
		System.out.println(Integer.toOctalString(i8));//27
	}
	
	
}
