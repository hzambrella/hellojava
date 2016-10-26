package swap;

// 值传递（利用返回数组）
public class ByValue {
	public static int[] swap(int x, int y) {
		System.out.println("其它类，返回数组的方法");
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
