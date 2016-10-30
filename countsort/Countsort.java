// ¼ÆÊýÅÅÐò
package countsort;

public class Countsort {

	public static int[] countBySort(int[] A) {
		int k = 0;
		k = ArrayUtils.maxInArray(A);
		int[] C = new int[k + 1];
		int[] B = new int[A.length];

		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;

		}
		// ArrayUtils.printArray(C);
		for (int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i - 1];

		}
		// ArrayUtils.printArray(C);
		// for (int j=A.length-1;j>=0;j++){
		for (int j = A.length - 1; j >= 0; j--) {
			/*
			 * System.out.println(A[j]); System.out.println(C[A[j]]);
			 * System.out.println(B[C[A[j]]-1]);
			 */
			//B[A.length-(C[A[j]])] = A[j];
			B[(C[A[j]]-1)] = A[j];
			// ArrayUtils.printArray(B);
			C[A[j]]--;
			// ArrayUtils.printArray(C);

		}
		return B;
	}

	public static void main(String[] args) {
		Countsort sort = new Countsort();
		int[] array = { 10, 18, 80, 17, 50, 45, 76, 32, 87, 78, 80 };

		ArrayUtils.printArray(array);
		int[] after = {};
		after = countBySort(array);
		ArrayUtils.printArray(after);
	}
}
