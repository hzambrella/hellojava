package testAndtry;

public class PolymorphicTest {
	public static void main(String[] args) { 
		Drinker dr=new Drinker();
		JNC j1=new JNC();
		j1.price();
		
		//����ת�͡���������ָ���������
		Wine w1=new JNC();
/*		w1.price();*///����ת�ʹ���һЩȱ�����Ǿ������ض��ᵼ��һЩ���������ԵĶ�ʧ
		
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
		degree();//�����������д�Ļ��������Ҳ��ת��
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