package TestCollection;

import java.util.*;

import TestCollection.TestCollection.*;

import com.alibaba.fastjson.JSON;

public class TestCollections {
	static Staff peter = new Staff(20, "peter");
	static Staff mary = new Staff(22, "mary");
	static Staff ben = new Staff(40, "ben");
	static Staff li = new Staff(30, "li");
	
	public static void main(String[] args) {
		List<String>list=Collections.nCopies(10,"fasfa");
		System.out.println(JSON.toJSONString(list));
		
		Map<String,String> map=Collections.singletonMap("1", "gfasdfsa");
		//map.put("key", "value");//这里会报错
		System.out.println(map);
		testSort();
		testSearch();
	}
	public static void testSearch(){
		System.out.println("============testSort==========");	
		List<Staff>list1=new ArrayList<>();
		list1.add(peter);
		list1.add(mary);
		list1.add(ben);
		list1.add(li);
		
		System.out.println(Collections.binarySearch(list1, li,new StaffComparator()));
	}
	
	public static void testSort(){
		System.out.println("============testSort==========");
		List<Staff>list1=new ArrayList<>();
		list1.add(peter);
		list1.add(mary);
		list1.add(ben);
		list1.add(li);
		Collections.sort(list1,new StaffComparator());
		System.out.println(list1);
		Collections.sort(list1,Collections.reverseOrder(new StaffComparator()));
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
	}
}	
