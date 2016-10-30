package selectBySize;

public class SelectBySize {
	public static void main(String[] args) {
		int[] A = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(A);
		int[] B = { 9, 15, 17, 19, 21, 42, 46, 66, 81 };
		System.out.printf("排序好的话数组的样子");
		ArrayUtils.printArray(B);
		int ii = 3;
		int x = select(A, 0, 8, ii);
		System.out.printf("第%d小的数字为%d", ii, x);
	}

	// 选择算法 ,从数组A[p..r]找第ii小的元素
	public static int select(int[] A, int p, int r, int ii) {

		if ((r - p + 1) < 5) {
			insertSort(A, r, p);
			return A[p + ii - 1];
		}
		// 组数
		int n = (r - p) / 5 + 1;
		int[] B = new int[n];
		// 划分组，找出每组的中位数
		for (int i = 0; i < n; i++) {
			int left = p + 5 * i;
			// 注意最后一组的划分，可能不足五个元素。
			int right = p + 5 * i + 4 > r ? r : p + 5 * i + 4;
			// 每个组排序之后中位数在数组中的序号
			int middle = (left + right) / 2;
			// 进行插入排序
			insertSort(A, left, right);
			B[i] = A[middle];
		}
		// 根据找出的中位数，递归调用select，找到中位数中的中位数,中位数为第(n+1)/2小的数字
		int x = select(B, 0, n, (n + 1) / 2);
		// System.out.println("-----------partition----------");

		int k = partition(A, p, r, x);

		//System.out.printf("k:%d\n", k);
		//ArrayUtils.printArray(A);
		//System.out.printf("ii:%d\n", ii);
		// error
		if (k == ii + 1) {
			//System.out.println("yes1");
			return A[k - 1];
		}

		else if (ii <= k) {
			//System.out.println("yes2");
			return select(A, p, k, ii);
		} else {
			//System.out.println("yes3");

			return select(A, k + 1, r, ii);
		}
	}

	// 插入排序
	public static void insertSort(int[] a, int law, int high) {
		for (int i = law + 1; i <= high; i++) {
			int j = i - 1;
			int key = a[i];
			while (j >= law && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	// PARTITION过程
	public static int partition(int[] A, int p, int r, int k) {
		int i = p - 1;
		//System.out.println(k);
		// ArrayUtils.printArray(A);
		for (int j = p; j <= r; j++) {
			if (A[j] < k) {
				i++;
				// error
				ArrayUtils.exchangeElements(A, i, j);
			}
		}
		// 比k小的数有i个,那么k就是第i+1小的数字
		//ArrayUtils.printArray(A);
		// System.out.println("-----------partition end----------");
		return i;

	}

}
