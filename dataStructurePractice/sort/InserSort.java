package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * 插入排序  不合格
 */

//插入排序就和缕牌一样。对于相邻的两张牌。若前面的比后面的牛，后面的放在哨兵位置。
//然后前面的前面依次和哨兵对比。向后挪动，直到遇见比哨兵弱的牌，将哨兵插入对应的位置。
//别把比较顺序和移动顺序搞反了。
public class InserSort <T extends Comparable<T>>{
	public static void main(String[] args) {
		Integer[] tosort1={3,4,1,6,7,8,10,9,0,2};
		Integer[] tosort2={9,1,2,3,4,5,6,7,8,0};
		InserSort<Integer> inserSort=new InserSort<>();
		inserSort.sort(tosort1, false);
		System.out.println(Arrays.toString(tosort1));
		inserSort.sort(tosort2, true);
		System.out.println(Arrays.toString(tosort2));
	}
	
	
	public T[] sort(T[] tosort,boolean isRise){
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		T flag;//哨兵
		for(int i=1;i<tosort.length;i++){
			if(!(tosort[i-1].compareTo(tosort[i])>0^isRise)){//前面的比后面的牛
				flag=tosort[i];//后面的设置成哨兵
				int j=i;
				//for (j=i-1;(j<tosort.length-1)&&!(flag.compareTo(tosort[j])<0^isRise);j++){
				for (j=i-1;(j>=0)&&!(flag.compareTo(tosort[j])<0^isRise);j--){
					tosort[j+1]=tosort[j];//牛的牌向后移动
				}
				tosort[j+1]=flag;
			}
		}
		
		
		return tosort;
	}
}
