package testAndtry;

//¼Ì³Ğ²âÊÔ
public class TestIneritChildren extends TestIneritFather{
	private int money=1000;
	public static void main(String[] args) {
		TestIneritChildren child =new TestIneritChildren();
		int m=child.money;//ÀàÄÚ²¿
		System.out.println(m);
		System.out.println(child.getMoney());//1000 or 100 or error
	}
	
	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
}
