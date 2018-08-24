package zhaogongzuo2018.practice.util;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		String[] strs={"1","3213","da","dfasf"};
		System.out.println(Arrays.toString(Arrays.copyOf(strs, 10)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(strs, 1,10)));
		
		Integer[][]arr={{1,2,3},{2,31,32},{5,7,6}};
		Integer[][]arr2=new Integer[3][];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr));
		System.out.println(arr.equals(arr2));
		System.out.println(Arrays.deepEquals(arr, arr2));
		Arrays.fill(strs,1,3,"hao");
		System.out.println(Arrays.toString(strs));
	}
}
