package hellojava.selectBySize;

//最坏情况为线性时间的选择算法

// 居然花了一个星期天的晚上和一个周一的上午才搞完！！！疯了！！！
// 编程都用数组序号，不是下标，防止蒙蔽。处理数组元素的时候，括号里面的减1即可
// A[]的括号当中注意减1
// 每次填完一个序号要模拟一下，出现的bug基本上都是数组溢出的错误
// 注释你的参数。写明白它的意义
// 中位数为(lengh+1)/2
// 怎么实现插入排序
// 怎么实现数组划分Partiton
public class SelectBySize {
	public static void main(String[] args) {
		int[] A = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(A);
		int[] B = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		System.out.printf("排序好的话数组的样子");
		insertSort(B, 1, 9);
		ArrayUtils.printArray(B);
		for (int ii = 1; ii <= 2; ii++) {
			// int ii = 2;
			int x = select(A, 8, 9, ii);
			System.out.printf("==========第%d小的数字为%d=========================\n", ii, x);
		}
	}

	// 选择算法 ,从数组A[p..r]找第ii小的元素,p,r是数组的序号。第一个为1。ii是p到r当中第几个最小的数
	public static int select(int[] A, int p, int r, int ii) {

		// 检查点-----------------------------
		// System.out.printf("----start %d-----",ii);
		// ArrayUtils.printArray(A);
		// -----------------------------------

		if ((r - p + 1) < 5) {
			insertSort(A, p, r);
			ArrayUtils.printArray(A);
			System.out.printf("p:%d  ii:%d  A[%d]:\n", p, ii, p + ii - 1);
			// error
			// 比如 1 2 3 4 p=2， ii=2, 是3 ，A[2]
			return A[p + ii - 2];
		}

		// 组数为（high-low）/5+1
		int n = (r - p) / 5 + 1;
		int[] B = new int[n];
		// 划分组，找出每组的中位数,left，right都是数组的序号,不是数组的下标。
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

		// 检查点-----------------------------
		System.out.print("A:");
		ArrayUtils.printArray(A);
		System.out.print("B:");
		ArrayUtils.printArray(B);
		// 检查点-----------------------------
		// 中位数在(b+1)/2,b是中位数数组的长度。
		int b=B.length;
		int v = (b + 1) / 2;
		// System.out.printf("select(B,1,%d,%d)\n",b,v);
		// 根据找出的中位数，递归调用select，找到中位数中的中位数,中位数为第(n+1)/2小的数字

		int x = select(B, 1, b, v);

		System.out.println("-----------partition----------");
        // k是分治中点在数组当中的序号，即k是第几小的数
		int k = partition(A, p, r, x);

		// 检查点-----------------------------
		ArrayUtils.printArray(A);
		System.out.printf("第一部分末尾：k:%d\n", k);
		System.out.printf("ii:%d\n", ii);
		// 检查点-----------------------------

		// error
		if (k  == ii) {
			System.out.printf("yes1  A[%d]\n", p + k);
			return A[p + k-2];
		}

		else if (k  > ii) {
			System.out.printf("yes2 select(A, %d, %d, %d)\n", p, p + k - 2, ii);
			return select(A, p, p + k - 2, ii);
		} else {
			System.out.printf("yes3 select(A, %d, %d, %d)\n", p + k , r, ii - k);

			return select(A, p + k, r, ii - k);
		}
	}

	// 插入排序
	public static void insertSort(int[] a, int law, int high) {

		for (int i = law + 1; i <= high; i++) {
			int j = i - 1;
			int key = a[i - 1];
			while (j >= law && a[j - 1] > key) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = key;
		}
	}

	// PARTITION过程
	// p,r是数组A的第p个数到第r个数的序号，k是中位数的中位数。返回的是k为第几小的数字
	public static int partition(int[] A, int p, int r, int k) {
		// i是第一部分元素的数量。
		int i = 0;
		// 检查点-----------------------------
		System.out.printf("中位数：k:%d  p:%d  r:%d\n划分前的数组", k, p, r);
		ArrayUtils.printArray(A);
		// 检查点-----------------------------
		// mid是中间点的序号
		int mid = 0;
		for (int j = p; j <= r; j++) {
			if (A[j-1] < k) {
				i++;
				System.out.printf("i:%d\n", i);
				// error
				// 参数为序号，非下标
				ArrayUtils.exchangeElements(A, p + i-1, j);
				ArrayUtils.printArray(A);
				System.out.print("划分中的数组：");
				ArrayUtils.printArray(A);
			}
			if (A[j-1] == k) {
				mid = j;
			}
		}
		// 比k小的数有i个,那么k就是第i+1小的数字
		ArrayUtils.exchangeElements(A, mid-1, p + i-1);
		System.out.println("-----------partition end----------");
		return i+1;

	}

}
