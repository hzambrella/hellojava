// 操作数组的工具包

package arrayUtils;
// 数组工具
// printArray:打印数组
// exchageElements:交换数组元素
// maxInArray:数组中的最大值
public class Arrayutils {
	//打印int数组
		 public static void printArray(int[] array) {  
	        System.out.print("{");  
	        for (int i = 0; i < array.length; i++) {  
	            System.out.print(array[i]);  
	            if (i < array.length - 1) {  
	                System.out.print(", ");  
	            }  
	        }  
	        System.out.println("}");  
	    }  
	//交换数组当中元素
	    public static void exchangeElements(int[] array, int index1, int index2) {  
	        int temp = array[index1];  
	        array[index1] = array[index2];  
	        array[index2] = temp;  
	    }  

	//找到数组中最大值
	public static int maxInArray(int[] A){
		int max=0;
	for(int x:A){
		if (x>=max){
		max=x;	
		}
	}
	return max;
	}
}
