package zhaogongzuo2018.practice.util;

import java.util.*;

public class TestNavigableMap {
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		TreeMap<String,String> map=new TreeMap<>();
		map.put("aad","dada");
		map.put("bad","dada");
		map.put("cad","dada");
		map.put("dad","dada");
		
		System.out.println(map.ceilingKey("c"));
		System.out.println(map.headMap("dadd"));
	}
}
