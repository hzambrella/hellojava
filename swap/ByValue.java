package swap;

// ֵ���ݣ����÷������飩
public class ByValue {
	public static int[] swap(int x, int y) {
		System.out.println("�����࣬��������ķ���");
		x = x ^ y;
		//System.out.println("x=x^y:" + x);
		y = y ^ x;
		//System.out.println("y=y^x:" + y);
		x = x ^ y;
		//System.out.println("x=x^y:" + x);
		int[] array = { x, y };
		return array;
	}
}
