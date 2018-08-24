package zhaogongzuo2018.practice.util;

import java.util.LinkedList;

public class TestDeque {
	public static void main(String[] args) {
		TestDequeApi();
	}
	
	public static void TestDequeApi(){
		LinkedList<String> list=new LinkedList<>();
		list.add("dasda");
		list.push("da");
		list.offer("d");
		System.out.println(list.peek()==list.getFirst());
		System.out.println(list.peek()==list.element());
		list.offer("daa");
		System.out.println(list);
		System.out.println(list.removeFirstOccurrence("d"));
		System.out.println(list);
	}
}
