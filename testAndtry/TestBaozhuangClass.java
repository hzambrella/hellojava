package testAndtry;

public class TestBaozhuangClass {
	public static void main(String[] args) {
		System.out.println("==========String=====");
		String s="123";
		String ss=s;
		System.out.println(s.hashCode()+","+ss.hashCode());
		System.out.println(s==ss);
		//String�ǲ��ɱ�ġ�
		s="456";
		System.out.println(s.hashCode()+","+ss.hashCode());
		System.out.println(s==ss);
		//Stringӵ�л��档
		s="123";
		System.out.println(s.hashCode()+","+ss.hashCode());
		System.out.println(s==ss);
		
		//Stringӵ�л��档
		String sa="aaa";
		String sa2=new String("aaa");
		System.out.println(sa.hashCode()+","+sa2.hashCode());
		
		System.out.println("==========Boolean=====");
		//boolean��true��false������Boolean��ľ�̬final����
		Boolean b1=true;
		Boolean b2=b1;
		System.out.println(b1==b2);
		System.out.println(b1.hashCode()+","+b2.hashCode());
		b1=false;
		System.out.println(b1.hashCode()+","+b2.hashCode());
		System.out.println(b1==b2);
		
		System.out.println("==========Integer=====");
		Integer i1=1;
		Integer i2=i1;
		System.out.println(i1==i2);
		System.out.println(i1.hashCode()+","+i2.hashCode());
		i1=1;
		System.out.println(i1.hashCode()+","+i2.hashCode());
		System.out.println(i1==i2);
		
		System.out.println("==========Double=====");
		Double d1=1.0;
		Double d2=d1;
		System.out.println(d1==d2);
		System.out.println(d1.hashCode()+","+d2.hashCode());
		d1=1.1;
		System.out.println(d1.hashCode()+","+d2.hashCode());
		System.out.println(d1==d2);
		
		System.out.println("==========String[]=====");
		//==�Ǳȵ�ַ��
		String[] sl={"a"};
		String[]sl2=sl;
		System.out.println(sl==sl2);
		
		System.out.println(sl.hashCode());
		
		sl[0]="12321";
		System.out.println(sl==sl2);
		System.out.println(sl.hashCode());
		
		
		
		
	}
}
