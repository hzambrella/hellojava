package dataStructurePractice.sort;

import java.util.Arrays;

//ºÚµ•≈≈–Ú
public class SimpleSort <T extends Comparable<T>> {
	public static void main(String[] args) {
		Integer[] tosort={3,4,1,6,7,8,10,9,0,2};
		Integer[] tosort2={9,1,2,3,4,5,6,7,8,0};
		SimpleSort<Integer> simpleSort=new SimpleSort<>();
		simpleSort.sort(tosort, false);
		simpleSort.sort(tosort2, true);
		System.out.println(Arrays.toString(tosort));
		System.out.println(Arrays.toString(tosort2));
	}
	
	
	public T[] sort(T[] tosort,boolean isRise){
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		for (int i=0;i<tosort.length;i++){
			for (int j=i+1;j<tosort.length;j++){
				if (!(tosort[i].compareTo(tosort[j])>0^isRise)){
					swap(tosort,i,j);
				}
			}
		}
		
		return tosort;
	}
	
	private void swap(T[] tosort,int begin,int end){
		T t=tosort[begin];
		tosort[begin]=tosort[end];
		tosort[end]=t;
	}
}
