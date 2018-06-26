package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 插入排序  不合格
 */
public class InserSort {
	public static List<Integer> sort(List<Integer> list,boolean ascending){
		List<Integer> l=new ArrayList<Integer>();
		Iterator<Integer> iterator=list.iterator();
		int guard=0;//哨兵
		
		l.add(guard);
		while (iterator.hasNext()){
			Integer i=(Integer) iterator.next();
			l.add(i);
		}
		int length=l.size();
		
		for (int i=2;i<length;i++){
			int j=i-1;
			if ((l.get(i)<l.get(i-1)&&ascending)||(l.get(i)>l.get(i-1)&&!ascending)){
				l.set(0,l.get(i));
				j=i-1;
				//for (j=i-1;((l.get(j)>l.get(0)&&ascending)||(l.get(j)<l.get(0)&&!ascending));j--){
				while((l.get(j)>l.get(0)&&ascending)||(l.get(j)<l.get(0)&&!ascending)){
					l.set(j+1,l.get(j));
					j--;
				}
				
				l.set(j+1,l.get(0));
			}
		}
		
		l.remove(0);
		
		return l;	
	}
	
	public static void main(String[] args) {
		List<Integer>l=new ArrayList<Integer>();
		int[] array={11,9,3,1,2,14,6,7,8,5,4,12,13};
		for (int i:array){
			l.add(i);
		}
		System.out.println(l);
		List<Integer> result=InserSort.sort(l, true);
		System.out.println(InserSort.class.getName()+":"+result);
	}
}
