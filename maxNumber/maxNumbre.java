package maxNumber;
// 可变参数
public class maxNumbre {
	public static void main(String args[]) {
		// maxNum(new int[]={1,2,5,8,0});
		maxNum(new int[] { 1, 2, 5, 8, 0 });
		maxNum(21,32,45,12,2,34);
	}

	// public static int max(...int){
	public static void maxNum(int... num) {
		if (num.length == 0) {
			System.out.println("no num");
		}
		int result = 0;

		for (int x : num) {
			if (x > result) {
				result = x;
			}
		}
		System.out.println(result);
	}
}
