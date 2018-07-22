package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Arrays;


//归并排序。
//思路是两个序列合成一个序列。两个序列两个指针，打擂。输掉的把元素放在另一个数组。并且指针后移动。
//最后若是有序列剩有元素，将元素放在数组中。最终得到的数组就是两个序列归并的结果。
public class MergeSort  <T extends Comparable<T>>{
	
	public static void main(String[] args) {
		Integer[] tosort1={3,4,1,6,7,8,10,9,0,2};
		
		Integer[] tosort2={9,1,2,3,4,5,6,7,8,0};
		
		MergeSort<Integer> mergeSort=new MergeSort<>();
//		System.out.println(Arrays.toString(tosort1));
		mergeSort.sort(tosort1, true);
		System.out.println(Arrays.toString(tosort1));
//		System.out.println(Arrays.toString(tosort2));
		mergeSort.sort(tosort2, false);
		System.out.println(Arrays.toString(tosort2));
	}
	
	
	public T[] sort(T[] tosort,boolean isRise){
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		merge(tosort,0,tosort.length-1,isRise);
		
		return tosort;
	}
	
	private void merge(T[] tosort,int begin,int end,boolean isRise){
		if (begin>=end){
			return;
		}
		
		merge(tosort,begin,(end+begin)/2,isRise);
		merge(tosort,(end+begin)/2+1,end,isRise);
		
		ArrayList<T>list=new ArrayList<>();
		
		int low=begin;
		int high=(end+begin)/2+1;
		
		
		while(low<=(end+begin)/2&&high<=end){
			if (!(tosort[low].compareTo(tosort[high])<0^isRise)){
				list.add(tosort[low]);
				low++;
			}else{
				list.add(tosort[high]);
				high++;
			}
		}
		
		while(low<=(end+begin)/2){
			list.add(tosort[low]);
			low++;
		}

		
		while(high<=end){
			list.add(tosort[high]);
			high++;
		}
		
		int index=begin;

		while(!list.isEmpty()){
			T t=list.remove(0);
			tosort[index]=t;
			index++;
		}
		
	}	
}
