package zhaogongzuo2018.practice.util;

import java.util.*;


public class Try {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		Integer[] a=new Integer[9];
		System.out.println(Arrays.toString(list.toArray(a)));
		
		BitSet bs1=new BitSet(4);
		BitSet bs2=new BitSet(4);
		bs1.set(1);
		bs1.set(3);
		bs2.set(3);
		bs1.and(bs2);
		System.out.println(bs1.toString());
		
		
		Random random=new Random();
		for (int i=0;i<10;i++){
			System.out.print(random.nextInt(10)+"  "+System.lineSeparator());
		}
		
		System.out.println(1E-2);
		Stack<Integer>sta=new Stack<>();
		sta.isEmpty();
		sta.push(1);
		System.out.println(sta.pop());
		sta.push(2);
		sta.push(3);
		System.out.println(sta.pop());
		sta.push(4);
		sta.push(5);
		System.out.println(sta.pop());
	}
}
