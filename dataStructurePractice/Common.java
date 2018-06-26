package dataStructurePractice;

import java.util.List;

public class Common {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void swap(List list,int i,int j){
		Object oi=list.get(i);
		list.set(i, list.get(j));
		list.set(j, oi);
	}
}
