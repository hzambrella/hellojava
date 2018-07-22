package dataStructurePractice.search;

//˳������--���ַ�

//ע�������begin+1 end-1
public class BinarySearch<T extends Comparable<T>> {
	public static void main(String[] args) {
		Integer[] tosearch={1,4,6,10,23,34,56,78,90};
		BinarySearch<Integer> search=new BinarySearch<>();
		System.out.println(search.search(tosearch, 22));
		System.out.println(search.search(tosearch, 34));
		System.out.println(search.search(tosearch, 78));
		System.out.println(search.search(tosearch, 4));
	}
	/**
	 * 
	 * @param tosearch �������У���������������ġ�
	 * @param target  Ŀ��Ԫ��
	 * @return ����Ԫ���������е�λ��
	 */
	public int search(T[] tosearch,T target){
		if (tosearch.length==0){
			return -1;
		}
		
		if (tosearch.length==1){
			return 0;
		}
		
		int begin=0;
		int end=tosearch.length-1;
		int mid=(begin+end)/2;
		
		while(begin<=end){
			if (target.compareTo(tosearch[mid])<0){
//				end=mid;
				end=mid-1;//ע�⣡����
			}else if(target.compareTo(tosearch[mid])>0){
//				begin=mid;
				begin=mid+1;//ע�⣡����
			}else{
				return mid;
			}
			
			mid=(begin+end)/2;
		}
		
		
		return -1;
	}
}
