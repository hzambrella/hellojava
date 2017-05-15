package hellojava.insertsort;

import hellojava.selectBySize.ArrayUtils;

//≤Â»Î≈≈–Ú
public class InsertSort {
	public static void insertSort(int[] a, int law, int high) {
		for (int i = law + 1; i <= high; i++) {
			int key = a[i - 1];
			int j = i - 1;
			while (j >= law && a[j - 1] > key) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = key;
		}
	}

	public static void main(String[] args) {
		int[] a = { 42, 21, 6, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(a);
		insertSort(a, 1, 9);
		ArrayUtils.printArray(a);
	}
}
