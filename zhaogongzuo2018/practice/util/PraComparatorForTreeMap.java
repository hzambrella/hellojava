package zhaogongzuo2018.practice.util;

import java.util.Comparator;
import java.util.TreeMap;

//String����ҪComparator �ڲ�ʵ����Comparable
public class PraComparatorForTreeMap implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.equals(o2)){
			return 0;
		}
		return o1.compareTo(o2);
	}
	
	public static void main(String[] args) {
		PraComparatorForTreeMap pm=new PraComparatorForTreeMap();
		TreeMap<String,Integer>t=new TreeMap<String, Integer>();
		t.put("c",1);
		t.put("a",2);
		t.put("b",3);
		
		System.out.println(t.toString());
	}
	
}	
