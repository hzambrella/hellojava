// ��������������
// һ��Դ�ļ�ֻ����һ��public��
package hellojava.variables;

public class Variables {
	private int aa = 2;
	public static int aaa=3;
public  void b(){
	int aa=1;
	System.out.println("�ֲ�����aa:"+aa);
	System.out.println("ʵ������aa:"+this.aa);
	System.out.println("���������̬������aaa"+this.aaa);
	this.aa=this.aa+1;
}

public static void add(int x){
	
	aaa=aaa+x;
}

public static void main(String []args){
	new Variables().b();
	Variables.add(2);
	//ʵ������û�䣬���������̬����������
	new Variables().b();
}
}
