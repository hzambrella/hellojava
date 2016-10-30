//
package selectBySize;

//工具
public class ArrayUtils {
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
