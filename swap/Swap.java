package swap;
//ֵ���ݺ����ô���

public class Swap {
	public static int x;
	public static int y;

	// public void Swap (int x,int y)
	public Swap(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//(ʧ��)
	public static void swap0(int x,int y){
		System.out.println("ֵ���ݣ�");
		x=x^y;
		y=y^x;
		x=x^y;
	}
	//���ɹ���
	public static void swap(Swap my0){
		System.out.println("���ô��ݣ�");
		my0.x=my0.x^my0.y;
		my0.y=my0.y^my0.x;
		my0.x=my0.x^my0.y;
	}

	public static void main(String[] args) {
		Swap my = new Swap(21, 32);
		// ֵ����
		Swap.swap0(my.x,my.y);
		System.out.printf("now:%d %d \n", my.x, my.y);
		//ָ�봫��
		Swap.swap(my);
		System.out.printf("now:%d %d \n", my.x, my.y);
		int[] list = ByValue.swap(my.x, my.y);
		System.out.printf("before:%d %d \n", my.x, my.y);
		System.out.printf("in list:%d %d\n", list[0], list[1]);
		
	}
}
