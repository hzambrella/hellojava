package testAndtry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestGenerics {
	// public static void main(String[] args) {
	// Box<String>box1=new Box<String>("abc");
	// Box<Integer>box2=new Box<Integer>(199);
	// System.out.println("check class:"+(box1.getClass()==box2.getClass()));
	// //true ���������Ͳ�ͬ����Ӱ�������Ƿ���ͬ
	// }

	public static void main(String[] args) {
		Box<Number> bx1 = new Box<Number>(1);
		Box<Integer> bx2 = new Box<Integer>(1);
		printNumber(bx1);
		printNumber(bx2);
		Integer[] intArray=new Integer[]{1,2,3};
		int[] intArray1=new int[]{1,2,3};
		String[] stringArray=new String[]{"12","1231"};
		Integer[] result=printArray(intArray,stringArray);
		//printArray(intArray1,stringArray);//����
	}

	//public static void getNumber(Box<Number> box) { �ᱨ��
	public static void printNumber(Box<? extends Number> box) {
		System.out.println(box.getData());
	}
	
	//���ͷ���
	public static <T,E>T[] printArray(T[] tarray,E[] earray){
		System.out.println(tarray);
		System.out.println(earray);
		return tarray;
	}

	static class Box<E> {
		public E data;

		public Box(E data) {
			this.data = data;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}
	}
}
