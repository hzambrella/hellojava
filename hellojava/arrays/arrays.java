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
		// �������
		Arrays.fill(array, 1,5,3);
		System.out.println("������飺Arrays.fill(array, 5)��");
		output(array);

		// ������ĵ�2�͵�3��Ԫ�ظ�ֵΪ8
		Arrays.fill(array, 2, 4, 8);
		System.out.println("������ĵ�2�͵�3��Ԫ�ظ�ֵΪ8��Arrays.fill(array, 2, 4, 8)��");
		output(array);

		int[] array1 = { 7, 8, 3, 2, 12, 6, 3, 5, 4 };
		// ������ĵ�2������6�����������������
		Arrays.sort(array1, 2, 7);
		System.out.println("������ĵ�2������6��Ԫ�ؽ��������������Arrays.sort(array,2,7)��");
		output(array1);

		// �����������������
		Arrays.sort(array1);
		System.out.println("�����������������Arrays.sort(array1)��");
		output(array1);

		int[] array01=new int[]{1,2,3,4,5};
		int[] array02=new int[]{1,2,3,4,5};
		// �Ƚ�����Ԫ���Ƿ����
		System.out.println("�Ƚ�����Ԫ���Ƿ����:Arrays.equals(array, array1):" + "\n"
				+ Arrays.equals(array01, array02));
		int[] array2 = array1.clone();
		System.out.println("��¡������Ԫ���Ƿ����:Arrays.equals(array1, array2):" + "\n"
				+ Arrays.equals(array1, array2));

		// ʹ�ö��������㷨����ָ��Ԫ�����ڵ��±꣨����������õģ�����������ȷ��
		Arrays.sort(array1);
		System.out.println("Ԫ��3��array1�е�λ�ã�Arrays.binarySearch(array1, 3)��"
				+ "\n" + Arrays.binarySearch(array1, 3));
		// ��������ھͷ��ظ���
		System.out.println("Ԫ��9��array1�е�λ�ã�Arrays.binarySearch(array1, 9)��"
				+ "\n" + Arrays.binarySearch(array1, 9));
		
		String[][] name1 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};  
		String[][] name2 = {{ "G","a","o" },{ "H","u","a","n"},{ "j","i","e"}};  
		  
		System.out.println("���ڶ�ά���� equals��Ȼ���أ�"+Arrays.equals(name1, name2));    // false  
		System.out.println("deep equals�������⣺"+Arrays.deepEquals(name1, name2));// true  deep equals��������
		
		List<Object[]> l=Arrays.asList(new Object[][]{{1,2,3},{4,5,6},{7,8,9}});
		System.out.println("��ά���� ��ǿfor:");
		for (Object[] ol:l){
			output(ol);
		}
		
		System.out.println("��ά���� ������:");
		Iterator iterator=l.iterator();
		while(iterator.hasNext()){
			Object[] ol=(Object[]) iterator.next();
			output(ol);
		}
	}

}
