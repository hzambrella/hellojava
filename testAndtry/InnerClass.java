package testAndtry;

public class InnerClass {
	int a;
	static int b;
	private int c;
	
	interface testInterface{
/*		public int a;*/
		final int b=1;
		static int c=2;
		void test();
		
		class ac{
			
		}
	}

	// 成员内部类
	public class MemberInner {
		/* static int a; */// 不可定义static
		private int a;


		public void test() {
			System.out.println(this.getClass().getName());
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}

	public static class StaticInner {
		int b;
		static int a;
		static void staticMethod(){
			System.out.println("static method for StaticInner");
		}

		void test() {
			System.out.println(this.getClass().getName());
			// 不可访问外部的非static
			/* System.out.println(a); */
			System.out.println(b);
			/* System.out.println(c); */
		}
	}
	
	public void test(){
		final int a=1;//JDK8以下，局部内部类只可访问final局部变量

		//局部内部类
		 class PartInner{
			 
			public void test(){
				System.out.println(this.getClass().getName());
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
		}
		PartInner i=new PartInner();
		i.test();
	}
	
	public void testAnonymous(){
		//匿名内部类
		new testInterface(){
			@SuppressWarnings("unused")
			int aaa;
			@Override
			public void test() {
				System.out.println(this.getClass().getName());
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
			@SuppressWarnings("unused")
			public void test222() {
				System.out.println(this.getClass().getName());
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}	
		}.test();
	}

	public static void main(String[] args) {
		InnerClass ic = new InnerClass();
		ic.test();
		ic.testAnonymous();
		MemberInner i1 = ic.new MemberInner();
		i1.test();
		
		
		
		int a=InnerClass.StaticInner.a;
		int b=new InnerClass.StaticInner().b;
		
		InnerClass.StaticInner is1=new InnerClass.StaticInner();
		InnerClass.StaticInner is2=new StaticInner();
		StaticInner is3=new StaticInner();
	

	}
}
