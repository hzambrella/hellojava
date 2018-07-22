package TestCollection;

import java.util.ArrayDeque;

public class TestDeque {
	public static void main(String[] args) {
		ArrayDeque<String>queue=new ArrayDeque();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		queue.add("E");
		
		System.out.println(queue.pop());
	}
}
