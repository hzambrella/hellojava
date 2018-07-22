package dataStructurePractice.sort;

import java.util.Arrays;

//不需要建立树这个数据结构。堆是完全二叉树。
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
		
		//构建顶堆
		for (int i=tosort.length/2;i>0;i--){ //不是下标。是第几个元素。
			heapAdjust(tosort,i,tosort.length,isRise);
		}
		System.out.println("初始的大顶堆："+Arrays.toString(tosort));
		
		//将堆顶的元素放到后面，然后更新顶堆
		for (int i=0;i<tosort.length;i++){
			swap(tosort,0,tosort.length-1-i);
			heapAdjust(tosort,1,tosort.length-i-1,isRise); //堆顶元素脱离堆，然后维护新堆。
		}
		
		return tosort;
	}
	
	/**顶堆的构建
	 * 
	 * @param tosort  堆，数组表示 start到end
	 * @param start  数组从第几个元素的开始。注意不是下标。
	 * @param end  数组从第几个元素的结束。注意不是下标。
	 * @param isRise  升序还是降序 升序true为大顶 降序false为小顶
	 */
	private void heapAdjust(T[] tosort,int start,int end ,boolean isRise){
		int j;//标记搜索的位置
		for (j=2*start;j<=end;j=j*2){//子树。j<=end防止越界。
			//两个子树谁最牛
			if ((j<end)&&!(tosort[j-1].compareTo(tosort[(j+1)-1])<0^isRise)){//j<end防止越界。
				j=j+1;//2*j代表左子树 2*j+1代表右子树
			}
			//如果堆顶最牛，不用比下去了。
			if (!(tosort[start-1].compareTo(tosort[j-1])>0^isRise)){
				break;
			}else{
				//否则要换位置
				swap(tosort,j-1,start-1);
			}
			
			//继续找子树的子树，看看子树的子树还有没有比堆顶大的元素。
			start=j;
		}
	}
	
	private void swap(T[] tosort,int begin,int end){
		T t=tosort[begin];
		tosort[begin]=tosort[end];
		tosort[end]=t;
	}
}
