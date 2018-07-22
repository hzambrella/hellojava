package dataStructurePractice.sort;

import java.util.Arrays;

//����Ҫ������������ݽṹ��������ȫ��������
public class HeapSort<T extends Comparable<T>>{
	public static void main(String[] args) {
		Integer[] tosort={3,4,1,6,7,8,10,9,0,2};
		HeapSort<Integer> heapSort=new HeapSort<>();
		heapSort.sort(tosort, false);
		System.out.println(Arrays.toString(tosort));
	}

	public T[] sort(T[] tosort, boolean isRise) {
		if (tosort.length==0||tosort.length==1){
			return tosort;
		}
		
		//��������
		for (int i=tosort.length/2;i>0;i--){ //�����±ꡣ�ǵڼ���Ԫ�ء�
			heapAdjust(tosort,i,tosort.length,isRise);
		}
		System.out.println("��ʼ�Ĵ󶥶ѣ�"+Arrays.toString(tosort));
		
		//���Ѷ���Ԫ�طŵ����棬Ȼ����¶���
		for (int i=0;i<tosort.length;i++){
			swap(tosort,0,tosort.length-1-i);
			heapAdjust(tosort,1,tosort.length-i-1,isRise); //�Ѷ�Ԫ������ѣ�Ȼ��ά���¶ѡ�
		}
		
		return tosort;
	}
	
	/**���ѵĹ���
	 * 
	 * @param tosort  �ѣ������ʾ start��end
	 * @param start  ����ӵڼ���Ԫ�صĿ�ʼ��ע�ⲻ���±ꡣ
	 * @param end  ����ӵڼ���Ԫ�صĽ�����ע�ⲻ���±ꡣ
	 * @param isRise  �����ǽ��� ����trueΪ�� ����falseΪС��
	 */
	private void heapAdjust(T[] tosort,int start,int end ,boolean isRise){
		int j;//���������λ��
		for (j=2*start;j<=end;j=j*2){//������j<=end��ֹԽ�硣
			//��������˭��ţ
			if ((j<end)&&!(tosort[j-1].compareTo(tosort[(j+1)-1])<0^isRise)){//j<end��ֹԽ�硣
				j=j+1;//2*j���������� 2*j+1����������
			}
			//����Ѷ���ţ�����ñ���ȥ�ˡ�
			if (!(tosort[start-1].compareTo(tosort[j-1])>0^isRise)){
				break;
			}else{
				//����Ҫ��λ��
				swap(tosort,j-1,start-1);
			}
			
			//������������������������������������û�бȶѶ����Ԫ�ء�
			start=j;
		}
	}
	
	private void swap(T[] tosort,int begin,int end){
		T t=tosort[begin];
		tosort[begin]=tosort[end];
		tosort[end]=t;
	}
}
