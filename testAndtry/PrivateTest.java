package testAndtry;

public class PrivateTest {
	private int a;
	
	public static void main(String[] args){
		PrivateTest t=new PrivateTest();
		int a=t.a;//类当中可以用。出了PrivateTest类就不能使用了
	}
}
