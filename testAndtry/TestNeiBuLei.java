package testAndtry;

//测试内部类加载时机
public class TestNeiBuLei {
	public static int haha=1;
	
	private static class Neibulei{
		private static final TestNeiBuLei singleton=new TestNeiBuLei("666");
		Neibulei(){
			System.out.println("loading Neibulei");
		}
	}
	
	public TestNeiBuLei(){
		
	}
	
	public TestNeiBuLei(String str){
		Neibulei.singleton.haha++;
		System.out.println(str);
	}
	
	public static final TestNeiBuLei getInstance(){
		return Neibulei.singleton;
	} 
	
	public static void main(String[] args) {
		System.out.println(TestNeiBuLei.haha);
		System.out.println(TestNeiBuLei.getInstance().haha);
	}
}
