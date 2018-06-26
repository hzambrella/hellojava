package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataStructurePractice.Common;

/*Ï£¶ûÅÅÐò
 * 
 */
public class ShellSort {
	public static List<Integer> sort(List<Integer> list,boolean ascending){
		List<Integer> l=new ArrayList<Integer>();
		Iterator<Integer> iterator=list.iterator();
		l.add(0);
		while (iterator.hasNext()){
			Integer i=(Integer) iterator.next();
			l.add(i);
		}
		int length=l.size();
		int increament=length;
		int j=0;
		do{
			increament=increament/3+1;
			
			for (int i=increament+1;i<length;i++){
				if ((l.get(i)<l.get(i-increament)&&ascending)||(l.get(i)>l.get(i-increament)&&!ascending)){
					l.set(0, l.get(i));
//					for (j=i-increament;j>0&&(l.get(j)>l.get(0)&&ascending)||((l.get(j)<l.get(0))&&!ascending);j-=increament){
					j=i-increament;
					while(j>0&&((l.get(j)>l.get(0)&&ascending)||((l.get(j)<l.get(0))&&!ascending))){
						l.set(j+increament, l.get(j));
						j-=increament;
					}
						//					}
					
					l.set(j+increament, l.get(0));
				}
			}
			
		}while(increament>1);
		
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
		List<Integer> result=ShellSort.sort(l, false);
		System.out.println(ShellSort.class.getName()+":"+result);
	}
}
