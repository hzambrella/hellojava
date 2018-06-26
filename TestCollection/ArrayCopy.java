package TestCollection;

import java.util.Arrays;

public class ArrayCopy {
	public static int[]testArray={1,2,3,4,5};
	
	public static void main(String[] args){
		int[]testArray2=new int[5];
		int[]testArray3=new int[5];
		int[]testArray4=new int[5];
		System.arraycopy(testArray, 0, testArray2, 0, 5);
		testArray3=testArray.clone();
		testArray4=Arrays.copyOf(testArray, 5);	
		
		
		System.out.println(Arrays.toString(testArray2));
		System.out.println(Arrays.toString(testArray3));
		System.out.println(Arrays.toString(testArray4));
		
		
		int[][] twoArray={{1,2},{2,3}};
		for (int[]i:twoArray)
			System.out.println(Arrays.toString(i));
		
	}
}
