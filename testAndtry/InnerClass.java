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

	// ��Ա�ڲ���
	public class MemberInner {
		/* static int a; */// ���ɶ���static
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
			// ���ɷ����ⲿ�ķ�static
			/* System.out.println(a); */
			System.out.println(b);
			/* System.out.println(c); */
		}
	}
	
	public void test(){
		final int a=1;//JDK8���£��ֲ��ڲ���ֻ�ɷ���final�ֲ�����

		//�ֲ��ڲ���
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
		//�����ڲ���
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
