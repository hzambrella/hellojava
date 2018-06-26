package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataStructurePractice.Common;

//冒泡排序
public class BubbleSort {

	public static List<Integer> sort(List<Integer> list,boolean ascending){
		//书上的：如果二层循环没有进行一次交换，说明有序了。下一个一层循环可以不用进行。
		boolean flag=true;
		List<Integer> l=new ArrayList<Integer>();
		Iterator<Integer> iterator=list.iterator();
		while (iterator.hasNext()){
			Integer i=(Integer) iterator.next();
			l.add(i);
		}
		
		
		int lenght=l.size();
		for (int i=0;i<lenght&&flag;i++){
			flag=false;
			for (int j=lenght-1;j>i;j--){
				if ((l.get(j)<l.get(j-1)&&ascending)||(l.get(j)>l.get(j-1)&&!ascending)){
					Common.swap(l, j, j-1);
					flag=true;
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
		List<Integer> result=BubbleSort.sort(l, true);
		System.out.println(BubbleSort.class.getName()+":"+result);
	}
}


