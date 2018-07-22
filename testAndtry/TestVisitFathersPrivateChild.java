package testAndtry;


//打印结果是什么呢？
public class TestVisitFathersPrivateChild extends TestVisitFathersPrivateFather{
	public String duotai="子类";
	
	static {
		System.out.println("child static 代码块");
	}
	
	{
		System.out.println("child 构造代码块");
	}
	
	TestVisitFathersPrivateChild(){
		super("from child constructor");
		//构造代码块加到这里！！
		System.out.println("child constructor");
	}
	
	public static void main(String[] args) {
		TestVisitFathersPrivateFather fatherOrChild=new TestVisitFathersPrivateChild();
		System.out.println(fatherOrChild.duotai);
	}
}
