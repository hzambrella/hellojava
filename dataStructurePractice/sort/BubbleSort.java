package dataStructurePractice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import dataStructurePractice.Common;

//ð������
public class BubbleSort<T extends Comparable<T>> {
	public static void main(String[] args) {
//		Integer[] tosort={3,4,1,6,7,8,10,9,0,2};
		Integer[] tosort={9,1,2,3,4,5,6,7,8,0};
		BubbleSort<Integer> bubbleSort=new BubbleSort<>();
		bubbleSort.sort(tosort, false);
		System.out.println(Arrays.toString(tosort));
	}
	
	
	public T[]sort(T[] tosort,boolean isRise){
		boolean hasSwap=true;//ð������ĸĽ���
		
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		for(int i=0;i<tosort.length;i++){//����ȥ�ľͲ����ˡ�
			if (!hasSwap){//��һ�ֵ����Ƿ��н�����
				break;//��û�У�ֹͣ�㷨����Ϊ˵�������Ѿ������ˡ�
			}
			
			hasSwap=false;
			for (int j=tosort.length-1;j>i&&j>0;j--){  //���µ����ϸ���
				if (!(tosort[j].compareTo(tosort[j-1])<0^isRise)){
					swap(tosort,j,j-1);
					hasSwap=true;
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


