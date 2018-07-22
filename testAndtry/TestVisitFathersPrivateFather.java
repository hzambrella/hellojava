package testAndtry;

public class TestVisitFathersPrivateFather {
	public String duotai="基类";
	
	
	static{
		System.out.println("static 代码块");
	}
	
	{
		System.out.println("构造代码块");
	}
	
	public String field1;
	TestVisitFathersPrivateFather(String field1){
		this.field1=field1;
		System.out.println("father constructor"+field1);
	}
	
	
}
