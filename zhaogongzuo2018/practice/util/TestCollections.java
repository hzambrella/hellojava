package zhaogongzuo2018.practice.util;

import java.util.*;

public class TestCollections {
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		ArrayList<String>list=new ArrayList<>();
		list.add("das");
		list.add("dass");
		Collections.addAll(list, "1","32","da");
		System.out.println(list);
		ArrayList<String>list2=new ArrayList<>(list);	
		System.out.println(Collections.disjoint(list, list2));
		
		System.out.println(Collections.frequency(list, "das"));
		
		ArrayList<String>list3=new ArrayList<>(Arrays.asList("3","2","8","1","2","3","1","2","3"));
		ArrayList<String>list4=new ArrayList<>(Arrays.asList("1","2","3"));
		
		System.out.println(Collections.lastIndexOfSubList(list3, list4));
		
		HashMap<String,Boolean>map1=new HashMap<>();

		Set<String> set1=Collections.newSetFromMap(map1);
		map1.put("3", true);
		set1.add("4");
		System.out.println("map"+map1);
		System.out.println("set"+set1);
		
		Collections.replaceAll(list3, "3", "a");
		System.out.println(list3);
		
		ArrayList<String>list5=new ArrayList<>(Arrays.asList("1","2","3","4","5","6"));
		Collections.rotate(list5, 3);//4
		System.out.println(list5);//[4, 5, 6, 1, 2, 3]
		
		List<String> ulist5=Collections.unmodifiableList(list5);
		System.out.println(ulist5==list5);//false
		Collections.rotate(list5, 3);
		System.out.println(ulist5);//有变化
		
		
		ArrayList<Integer>toFind=new ArrayList<>(Arrays.asList(4,5,1,2,9,7,3,6,8));
		System.out.println(Collections.binarySearch(toFind, 3));//必须是有序的
		ArrayList<Integer>toFind2=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println(Collections.binarySearch(toFind2, 3));
	}
}
