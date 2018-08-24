package zhaogongzuo2018.practice.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CVTE2018 {
	static String str = "abbbbgggggggggaaacccccffff";

	public static void main(String[] args) {
		method1(str);
		System.out.println(method2(str));
	}
	

	//排序  TreeMapp。但是好麻烦，，，，所以这个方法不行。只是联系，TreeMap想要按照值排序
	public static void method1(String str){
//		TreeMap<Character,Integer>map=new TreeMap<>(new Comparator<Map.Entry<Charactor,Integer>>(){
//			public int compare(Map.Entry<Charactor,Integer> m1,Map.Entry<Charactor,Integer> m2){
//				if (m1.getValue()==m2.getValue()){
//					return 0;
//				}
//				return m1.getValue()>m2.getValue()?1:-1;
//			}
//		});
		TreeMap<Character,Integer>map=new TreeMap<>();
	
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 0);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		List<Map.Entry<Character,Integer>>list=new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		System.out.println(list);
	}
	
	public static Character method2(String str) {
		// char的包装类是Character
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 0);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		Collection<Integer> counts = map.values();
		int min = Collections.min(counts);
		int index = str.length();
		char result = (char) str.indexOf(0);
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() == min) {
				int pos = str.indexOf(m.getKey());
				if (pos < index) {
					index = pos;
					result = m.getKey();
				}

			}
		}

		return result;
	}

	public void testAndTry() {
		HashMap map = new HashMap();
		map.entrySet();
	}

}