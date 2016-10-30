package selectBySize;

public class SelectBySize {
	public static void main(String[] args) {
		int[] A = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(A);
		int[] B = { 9, 15, 17, 19, 21, 42, 46, 66, 81 };
		System.out.printf("����õĻ����������");
		ArrayUtils.printArray(B);
		int ii = 3;
		int x = select(A, 0, 8, ii);
		System.out.printf("��%dС������Ϊ%d", ii, x);
	}

	// ѡ���㷨 ,������A[p..r]�ҵ�iiС��Ԫ��
	public static int select(int[] A, int p, int r, int ii) {

		if ((r - p + 1) < 5) {
			insertSort(A, r, p);
			return A[p + ii - 1];
		}
		// ����
		int n = (r - p) / 5 + 1;
		int[] B = new int[n];
		// �����飬�ҳ�ÿ�����λ��
		for (int i = 0; i < n; i++) {
			int left = p + 5 * i;
			// ע�����һ��Ļ��֣����ܲ������Ԫ�ء�
			int right = p + 5 * i + 4 > r ? r : p + 5 * i + 4;
			// ÿ��������֮����λ���������е����
			int middle = (left + right) / 2;
			// ���в�������
			insertSort(A, left, right);
			B[i] = A[middle];
		}
		// �����ҳ�����λ�����ݹ����select���ҵ���λ���е���λ��,��λ��Ϊ��(n+1)/2С������
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

	// ��������
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

	// PARTITION����
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
		// ��kС������i��,��ôk���ǵ�i+1С������
		//ArrayUtils.printArray(A);
		// System.out.println("-----------partition end----------");
		return i;

	}

}
