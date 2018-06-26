package hellojava.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class arrays {
	public static void output(Object[] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	public static void output(int[] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Object[] array = new Object[5];
		// 填充数组
		Arrays.fill(array, 1,5,3);
		System.out.println("填充数组：Arrays.fill(array, 5)：");
		output(array);

		// 将数组的第2和第3个元素赋值为8
		Arrays.fill(array, 2, 4, 8);
		System.out.println("将数组的第2和第3个元素赋值为8：Arrays.fill(array, 2, 4, 8)：");
		output(array);

		int[] array1 = { 7, 8, 3, 2, 12, 6, 3, 5, 4 };
		// 对数组的第2个到第6个进行排序进行排序
		Arrays.sort(array1, 2, 7);
		System.out.println("对数组的第2个到第6个元素进行排序进行排序：Arrays.sort(array,2,7)：");
		output(array1);

		// 对整个数组进行排序
		Arrays.sort(array1);
		System.out.println("对整个数组进行排序：Arrays.sort(array1)：");
		output(array1);

		int[] array01=new int[]{1,2,3,4,5};
		int[] array02=new int[]{1,2,3,4,5};
		// 比较数组元素是否相等
		System.out.println("比较数组元素是否相等:Arrays.equals(array, array1):" + "\n"
				+ Arrays.equals(array01, array02));
		int[] array2 = array1.clone();
		System.out.println("克隆后数组元素是否相等:Arrays.equals(array1, array2):" + "\n"
				+ Arrays.equals(array1, array2));

		// 使用二分搜索算法查找指定元素所在的下标（必须是排序好的，否则结果不正确）
		Arrays.sort(array1);
		System.out.println("元素3在array1中的位置：Arrays.binarySearch(array1, 3)："
				+ "\n" + Arrays.binarySearch(array1, 3));
		// 如果不存在就返回负数
		System.out.println("元素9在array1中的位置：Arrays.binarySearch(array1, 9)："
				+ "\n" + Arrays.binarySearch(array1, 9));
		
		String[][] name1 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};  
		String[][] name2 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};  
		  
		System.out.println("对于多维数组 equals居然返回："+Arrays.equals(name1, name2));    // false  
		System.out.println("deep equals才是正解："+Arrays.deepEquals(name1, name2));// true  deep equals才是正解
		
		List<Object[]> l=Arrays.asList(new Object[][]{{1,2,3},{4,5,6},{7,8,9}});
		System.out.println("多维数组 增强for:");
		for (Object[] ol:l){
			output(ol);
		}
		
		System.out.println("多维数组 迭代器:");
		Iterator iterator=l.iterator();
		while(iterator.hasNext()){
			Object[] ol=(Object[]) iterator.next();
			output(ol);
		}
	}

}
