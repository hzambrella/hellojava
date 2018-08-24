package zhaogongzuo2018.practice.util;

import java.util.*;

public class TestList {
	public static void main(String[] args) {
		testAndTry();
	}
	static void testAndTry(){
		String[] str1={"1e","1a","1b","1d","1c"};
		String[] str2={"1e1","1a1","1b1","1d1","1c1"};
	
		 ArrayList<String> list1=new ArrayList<>(Arrays.asList(str1));
		 ArrayList<String> list2=new ArrayList<>( Arrays.asList(str2));
		 list1.addAll(3, list2);
		 System.out.println(list1);
		 list1.add(1,"223");
		 System.out.println(list1.get(0));
		 
		 
		 List<String>testNull=new Vector<>();
		 testNull.add("1");
		 testNull.add(null);
		 testNull.add("1");
		 testNull.add(null);
		 testNull.add("1");
		 
		 StringBuffer buf=new StringBuffer();
		 buf.append("-1");
		 buf.append(",");
		 buf.append("1");
		 buf.append(",");
		 buf.append("1");
		 buf.append(",");
		 
		 ArrayList<Integer> testAdd=new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
		 
		 testAdd.add(0,20);
		 System.out.println(testAdd);
		 
		 System.out.println(testDouble(1,2));
	}
	static Double testDouble(Integer i1,Integer i2){
		return ((i1.doubleValue()+i2.doubleValue())/2);
	}
}
