package testAndtry;


//��ӡ�����ʲô�أ�
public class TestVisitFathersPrivateChild extends TestVisitFathersPrivateFather{
	public String duotai="����";
	
	static {
		System.out.println("child static �����");
	}
	
	{
		System.out.println("child ��������");
	}
	
	TestVisitFathersPrivateChild(){
		super("from child constructor");
		//��������ӵ������
		System.out.println("child constructor");
	}
	
	public static void main(String[] args) {
		TestVisitFathersPrivateFather fatherOrChild=new TestVisitFathersPrivateChild();
		System.out.println(fatherOrChild.duotai);
	}
}
