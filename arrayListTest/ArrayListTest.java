package arrayListTest;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		// ArrayList<string> list=new ArrayList<string>();
		ArrayList List = new ArrayList();
		
		//ArrayList List = new ArrayList(); 
		List.add(1); 
		List.add(2); 
		List.add(3);
		Object [] values = List.toArray();
		
		//list.add(1);
		//list.add(12);
		System.out.println(List);
		System.out.println(values);
		//int32[] values=(int32[])list.ToArray(typeof(int32));
		
	}
}
