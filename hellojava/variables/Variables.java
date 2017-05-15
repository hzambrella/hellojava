// 变量及其作用域
// 一个源文件只能有一个public类
package hellojava.variables;

public class Variables {
	private int aa = 2;
	public static int aaa=3;
public  void b(){
	int aa=1;
	System.out.println("局部变量aa:"+aa);
	System.out.println("实例变量aa:"+this.aa);
	System.out.println("类变量（静态变量）aaa"+this.aaa);
	this.aa=this.aa+1;
}

public static void add(int x){
	
	aaa=aaa+x;
}

public static void main(String []args){
	new Variables().b();
	Variables.add(2);
	//实例变量没变，类变量（静态变量）变了
	new Variables().b();
}
}
