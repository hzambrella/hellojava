package heapsort;

// ������
// ��һ������������
// �ڶ�����a[0]��a[heap_size]����
// �����������ֶѵ����ʣ�heap_size-1
// ���Ĳ����ظ��ڶ���,��������ֱ��heapsize=1
public class heapsort {
	public static void main(String[] args) {
		int[] array = { 31,43,12,31,10,9,34,56,60,10,90,56 };

		System.out.println("Before heap:");
		ArrayUtils.printArray(array);

		heapSort(array);

		System.out.println("After heap sort:");
		ArrayUtils.printArray(array);
	}

	// ����
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);
		System.out.println("----------now-----------");
		for (int i = array.length - 1; i >= 1; i--) {
			ArrayUtils.exchangeElements(array, 0, i);
// �������ֶѵ�����
// ע��heapsize�������
// �Լ�д��go���԰汾ÿ�ζ����ع�������
// ����������ͱ�����
			maxHeap(array, i, 0);
			System.out.println("next");
		}
	}

	// ��������/��С��
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	// ���ֶѵ�����
	// heapsize
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}
		// System.out.println(array);
		ArrayUtils.printArray(array);
		if (index != largest) {
			ArrayUtils.exchangeElements(array, index, largest);

			maxHeap(array, heapSize, largest);
		}
	}
}
