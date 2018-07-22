package dataStructurePractice.sort;

import java.util.Arrays;

public class FastSort<T extends Comparable<T>> {
	public static void main(String[] args) {
		Integer[] tosort={3,4,1,6,7,8,10,9,0,2};
		FastSort<Integer> fastSort=new FastSort<>();
		fastSort.sort(tosort, false);
		System.out.println(Arrays.toString(tosort));
	}
	
	public T[]sort(T[] toSort,boolean isRise){
		if(toSort.length==0||toSort.length==1){
			return toSort;
		}
		
		partition(toSort,0,toSort.length-1,isRise);
		
		return toSort;
	}
	
	private void partition(T[] tosort,int low,int high,boolean isRise){
		if (low>=high){
			return;
		}
		
		int begin=low;
		int end=high;
		//第一个元素作为中间元素。
		T pa=tosort[low];
		while(low<high){
			//high指针移动，直到遇到比分界点小的元素。
			while(low<high&&!(pa.compareTo(tosort[high])<=0^isRise)){
				high--;
			}
			swap(tosort,low,high);//交换
			
			//low指针移动，直到遇到比分界点大的元素
			while(low<high&&!(pa.compareTo(tosort[low])>=0^isRise)){
				low++;
			}
			swap(tosort,low,high);//交换
		}
		
		//处理分界点两边的。
		partition(tosort,begin,low-1,isRise);
		partition(tosort,low+1,end,isRise);
	}
	
	private void swap(T[] tosort,int begin,int end){
		T t=tosort[begin];
		tosort[begin]=tosort[end];
		tosort[end]=t;
	}
}
