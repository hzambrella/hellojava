package testAndtry;

public class Testijiajia {
	

	public static void  main(String[] args) {	   
		int i=1;
		int a=i++;
		System.out.println(a);
		Add add=new Add();
		int a2=add.increment(a);
		System.out.println(a2);
		int a3=add.increment2(a);
		System.out.println(a3);
	}
}

class Add{
	public int increment(int a){
		return a++;
	}
	
	public int increment2(int a){
		return ++a;
	}
}