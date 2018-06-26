package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataStructurePractice.Common;

//ºÚµ•≈≈–Ú
public class SimpleSort {
	public static List<Integer> sort(List<Integer> list,boolean ascending){
		List<Integer> l=new ArrayList<Integer>();
		Iterator<Integer> iterator=list.iterator();
		while (iterator.hasNext()){
			Integer i=(Integer) iterator.next();
			l.add(i);
		}
		int length=l.size();
		
		for (int i=0;i<length;i++){
			for (int j=i+1;j<length;j++){
				if ((l.get(j)<l.get(i)&&ascending)||(l.get(j)>l.get(i)&&!ascending)){
					Common.swap(l, i, j);
				}
			}
			
		}
		
		return l;	
	}
	
	public static void main(String[] args) {
		List<Integer>l=new ArrayList<Integer>();
		int[] array={9,3,1,2,6,7,8,5,4};
		for (int i:array){
			l.add(i);
		}
		System.out.println(l);
		List<Integer> result=SimpleSort.sort(l, true);
		System.out.println(SimpleSort.class.getName()+":"+result);
	}
}
