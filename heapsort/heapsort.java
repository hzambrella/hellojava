package heapsort;

// 堆排序
// 第一步：建立最大堆
// 第二步：a[0]和a[heap_size]交换
// 第三步：保持堆的性质，heap_size-1
// 第四步：重复第二步,第三步，直到heapsize=1
public class heapsort {
	public static void main(String[] args) {
		int[] array = { 31,43,12,31,10,9,34,56,60,10,90,56 };

		System.out.println("Before heap:");
		ArrayUtils.printArray(array);

		heapSort(array);

		System.out.println("After heap sort:");
		ArrayUtils.printArray(array);
	}

	// 排序
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);
		System.out.println("----------now-----------");
		for (int i = array.length - 1; i >= 1; i--) {
			ArrayUtils.exchangeElements(array, 0, i);
// 继续保持堆的性质
// 注意heapsize这个参数
// 自己写的go语言版本每次都是重构的数组
// 用这个参数就避免了
			maxHeap(array, i, 0);
			System.out.println("next");
		}
	}

	// 建立最大堆/最小堆
	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	// 保持堆的性质
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
