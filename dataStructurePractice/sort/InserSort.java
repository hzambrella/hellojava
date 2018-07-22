package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * ��������  ���ϸ�
 */

//��������ͺ�����һ�����������ڵ������ơ���ǰ��ıȺ����ţ������ķ����ڱ�λ�á�
//Ȼ��ǰ���ǰ�����κ��ڱ��Աȡ����Ų����ֱ���������ڱ������ƣ����ڱ������Ӧ��λ�á�
//��ѱȽ�˳����ƶ�˳��㷴�ˡ�
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
		
		T flag;//�ڱ�
		for(int i=1;i<tosort.length;i++){
			if(!(tosort[i-1].compareTo(tosort[i])>0^isRise)){//ǰ��ıȺ����ţ
				flag=tosort[i];//��������ó��ڱ�
				int j=i;
				//for (j=i-1;(j<tosort.length-1)&&!(flag.compareTo(tosort[j])<0^isRise);j++){
				for (j=i-1;(j>=0)&&!(flag.compareTo(tosort[j])<0^isRise);j--){
					tosort[j+1]=tosort[j];//ţ��������ƶ�
				}
				tosort[j+1]=flag;
			}
		}
		
		
		return tosort;
	}
}
