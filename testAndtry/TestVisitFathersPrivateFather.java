package testAndtry;

public class TestVisitFathersPrivateFather {
	public String duotai="����";
	
	
	static{
		System.out.println("static �����");
	}
	
	{
		System.out.println("��������");
	}
	
	public String field1;
	TestVisitFathersPrivateFather(String field1){
		this.field1=field1;
		System.out.println("father constructor"+field1);
	}
	
	
}
