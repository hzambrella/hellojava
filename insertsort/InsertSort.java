package insertsort;

import selectBySize.ArrayUtils;
//≤Â»Î≈≈–Ú
public class InsertSort {
	public static void insertSort(int[] a, int law, int high) {
		for (int i = law + 1; i <= high; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= law && a[j] > key) {
				a[j + 1] = a[j];
				j--; 
			}
			a[j + 1] = key;
			ArrayUtils.printArray(a);
		}
	}

	public static void main(String[] args) {
		int[] a = { 42, 21, 6, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(a);
		insertSort(a, 0, a.length-1);
		ArrayUtils.printArray(a);
	}
}
