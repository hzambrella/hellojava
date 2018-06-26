package TestCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestGenirc {
	public static void main(String[] args) {
		test2();
	}
	
	//±¨´í
	public static void test1(){
		List<String>list =new ArrayList<>();
		List listWithoutG=list;
		listWithoutG.add(new Date());
		String str=list.get(0);
		System.out.println(str);
	}
	
	public static void test2(){
		List<String>list =new ArrayList<>();
		List<String>safeList=Collections.checkedList(list,String.class);
		List listWithoutG=safeList;
		listWithoutG.add(new Date());
		String str=list.get(0);
		System.out.println(str);
	}
}
