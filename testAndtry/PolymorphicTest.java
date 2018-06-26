package testAndtry;

public class PolymorphicTest {
	public static void main(String[] args) { 
		Drinker dr=new Drinker();
		JNC j1=new JNC();
		j1.price();
		
		//向上转型。父类引用指向子类对象
		Wine w1=new JNC();
/*		w1.price();*///向上转型存在一些缺憾，那就是它必定会导致一些方法和属性的丢失
		
		dr.test(w1);
	}
}

class Drinker{
	public void test(Wine wine){
		wine.drink();
	}
}

interface a{

}

class Wine{
	public void drink(){
		System.out.println("WINE");
		degree();//这个被子类重写的话，里面的也会转型
	}
	
	public void degree() {
		System.out.println("WINE is 30");
	}
}

class JNC extends Wine{
	public void drink(String i){
		System.out.println("JNC");
		degree();
	}
	
	public void price(){
		System.out.println("JNC price");
	}
	
	public void degree() {
		System.out.println("JNC is 30");
	}
}

class WLY extends Wine{
	public void drink(){
		System.out.println("WLY");
		degree();
	}
	
	public void degree() {
		System.out.println("JNC is 30");
	}
}