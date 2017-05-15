package hellojava.selectBySize;

//����Ϊ����ʱ���ѡ���㷨

// ��Ȼ����һ������������Ϻ�һ����һ������Ÿ��꣡�������ˣ�����
// ��̶���������ţ������±꣬��ֹ�ɱΡ���������Ԫ�ص�ʱ����������ļ�1����
// A[]�����ŵ���ע���1
// ÿ������һ�����Ҫģ��һ�£����ֵ�bug�����϶�����������Ĵ���
// ע����Ĳ�����д������������
// ��λ��Ϊ(lengh+1)/2
// ��ôʵ�ֲ�������
// ��ôʵ�����黮��Partiton
public class SelectBySize {
	public static void main(String[] args) {
		int[] A = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		ArrayUtils.printArray(A);
		int[] B = { 42, 21, 46, 15, 66, 17, 81, 9, 19 };
		System.out.printf("����õĻ����������");
		insertSort(B, 1, 9);
		ArrayUtils.printArray(B);
		for (int ii = 1; ii <= 2; ii++) {
			// int ii = 2;
			int x = select(A, 8, 9, ii);
			System.out.printf("==========��%dС������Ϊ%d=========================\n", ii, x);
		}
	}

	// ѡ���㷨 ,������A[p..r]�ҵ�iiС��Ԫ��,p,r���������š���һ��Ϊ1��ii��p��r���еڼ�����С����
	public static int select(int[] A, int p, int r, int ii) {

		// ����-----------------------------
		// System.out.printf("----start %d-----",ii);
		// ArrayUtils.printArray(A);
		// -----------------------------------

		if ((r - p + 1) < 5) {
			insertSort(A, p, r);
			ArrayUtils.printArray(A);
			System.out.printf("p:%d  ii:%d  A[%d]:\n", p, ii, p + ii - 1);
			// error
			// ���� 1 2 3 4 p=2�� ii=2, ��3 ��A[2]
			return A[p + ii - 2];
		}

		// ����Ϊ��high-low��/5+1
		int n = (r - p) / 5 + 1;
		int[] B = new int[n];
		// �����飬�ҳ�ÿ�����λ��,left��right������������,����������±ꡣ
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

		// ����-----------------------------
		System.out.print("A:");
		ArrayUtils.printArray(A);
		System.out.print("B:");
		ArrayUtils.printArray(B);
		// ����-----------------------------
		// ��λ����(b+1)/2,b����λ������ĳ��ȡ�
		int b=B.length;
		int v = (b + 1) / 2;
		// System.out.printf("select(B,1,%d,%d)\n",b,v);
		// �����ҳ�����λ�����ݹ����select���ҵ���λ���е���λ��,��λ��Ϊ��(n+1)/2С������

		int x = select(B, 1, b, v);

		System.out.println("-----------partition----------");
        // k�Ƿ����е������鵱�е���ţ���k�ǵڼ�С����
		int k = partition(A, p, r, x);

		// ����-----------------------------
		ArrayUtils.printArray(A);
		System.out.printf("��һ����ĩβ��k:%d\n", k);
		System.out.printf("ii:%d\n", ii);
		// ����-----------------------------

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

	// ��������
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

	// PARTITION����
	// p,r������A�ĵ�p��������r��������ţ�k����λ������λ�������ص���kΪ�ڼ�С������
	public static int partition(int[] A, int p, int r, int k) {
		// i�ǵ�һ����Ԫ�ص�������
		int i = 0;
		// ����-----------------------------
		System.out.printf("��λ����k:%d  p:%d  r:%d\n����ǰ������", k, p, r);
		ArrayUtils.printArray(A);
		// ����-----------------------------
		// mid���м������
		int mid = 0;
		for (int j = p; j <= r; j++) {
			if (A[j-1] < k) {
				i++;
				System.out.printf("i:%d\n", i);
				// error
				// ����Ϊ��ţ����±�
				ArrayUtils.exchangeElements(A, p + i-1, j);
				ArrayUtils.printArray(A);
				System.out.print("�����е����飺");
				ArrayUtils.printArray(A);
			}
			if (A[j-1] == k) {
				mid = j;
			}
		}
		// ��kС������i��,��ôk���ǵ�i+1С������
		ArrayUtils.exchangeElements(A, mid-1, p + i-1);
		System.out.println("-----------partition end----------");
		return i+1;

	}

}
