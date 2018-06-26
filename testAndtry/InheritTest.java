package testAndtry;

interface m3 extends Runnable {

}

interface m2  {
	
}

interface m1 extends m2,m3{
	
}

abstract class abbase{
	private abbase(){	
	}
}

class base1{
	public static int a=3232;
	private int b;
/*	public base1(){
		System.out.println("base1");
	}*/
	
/*	public base1(int i){
		System.out.println("base11212");
	}*/
	
	public void testByBase(){
		System.out.println("testByBase1");
	}

}

class base2 extends base1{
	public static int a=13131;
	private int base2a;
	
	public base2(){
		
	}
	
	public base2(int i){
		/*super(1);*/
		System.out.println("base2"+this.a);
	}
	
	public void testByBase(int i){
		System.out.println("testByBase2"+i);
	}
}

class base3{
	
}

public class InheritTest{
	public static void main (String[] args){
		base2 b2=new base2(2);
		System.out.println("----");
		int a=b2.a;
		b2.testByBase(a);
/*		int a2=b2.base2a;*/
		
/*
		base1 b1=new base1();*/
		
		base1 b3=new base2(2);
	/*	b3.b;*/
		
		System.out.println("----");
		base2 b2n=new base2();
		
		base1 b1n=new base2();
		System.out.println(b2n.a+"----"+b1n.a);
		
	}
}
