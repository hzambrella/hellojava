package testAndtry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestGenerics2 {
	public static <E>List<E> Sort(List<E> list,boolean up,int i) {	
		List<E>list2=new ArrayList<E>();
		Iterator<E> iterator=list2.iterator();
		
		while(iterator.hasNext()){
			E e=iterator.next();
			list2.add(e);
		}
		
		//TODO£ºÅÅĞò
		
		return list2;
	}
	
	public static <E>void swap(List<E> list,int i,int j){
		E e=list.get(i);
		list.set(i,list.get(j));
		list.set(i, e);
	}
}
