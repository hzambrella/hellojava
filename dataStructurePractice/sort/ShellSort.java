package dataStructurePractice.sort;

import java.util.Arrays;

/*ϣ������ ���ϸ�
 *  �����������������Ԫ��������ʱ��Ч�ʸߡ����ԸĽ���ϣ������
 *  �����зֳ�С��ִ�в�������ֱ���ֳɵĶ���Ԫ������Ϊ1��
 *  �ֶΣ�increament=increament/3+1;  �Ѳ��������У���һ��Ԫ�ظ�Ϊ��increament��Ԫ�ء�
 */
public class ShellSort <T extends Comparable<T>>{
	
	public static void main(String[] args) {
		Integer[] tosort1={3,4,1,6,7,8,10,9,0,2};
		
		Integer[] tosort2={9,1,2,3,4,5,6,7,8,0};
		
		ShellSort<Integer> shellSort=new ShellSort<>();
//		System.out.println(Arrays.toString(tosort1));
		shellSort.sort(tosort1, true);
		System.out.println(Arrays.toString(tosort1));
//		System.out.println(Arrays.toString(tosort2));
		shellSort.sort(tosort2, false);
		System.out.println(Arrays.toString(tosort2));
	}
	
	public T[] sort(T[] tosort,boolean isRise){
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		int increament=tosort.length;
		T flag;
		do{	
			increament=increament/3+1;
			for (int i=increament;i<tosort.length;i++){
				if (!(tosort[i-increament].compareTo(tosort[i])>0^isRise)){
					flag=tosort[i];
					int j;
					for (j=i-increament;(j>=0)&&(!(flag.compareTo(tosort[j])<0^isRise));j-=increament){//j>-=0
						tosort[j+increament]=tosort[j];
					}
					tosort[j+increament]=flag;
				}
			}
		}while(increament>1);//��do..while  ��Ϊ���Ҫincreamet=1
		
		return tosort;
	}
}
