package TestCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		LinkedList<String>list=new LinkedList<>();
		list.add("d");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add(null);
		System.out.println(list.toString());
		
		ArrayList<String>alist=new ArrayList<>(list);
		
		String s=new String("da");
		
		
		List<String> view=alist.subList(0, alist.size());
		System.out.println(view.equals(alist));//居然返回true
		System.out.println(alist.toString());
		view.add("123");//这个add方法居然没报错
		System.out.println(alist.toString());//父list也受到影响
		alist.ensureCapacity(100);//结构性修改
		//view.add("123123");//这时操作视图会返回异常
		//System.out.println(alist.toString());
		
		ArrayList<String>alist2=new ArrayList<>(1);
		List<String> view2=alist2.subList(0, alist2.size());
		view2.add("1");
		System.out.println(alist2.toString());
		
		
		
		String[] strarray={"11","3123","b","das","dasd"};
		List<String> starray=Arrays.asList(strarray);
		//starray.add("1231");//报错
	}
}
