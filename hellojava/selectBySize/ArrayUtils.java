//
package hellojava.selectBySize;

//����
public class ArrayUtils {
	//��ӡint����
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
//�������鵱��Ԫ��
    public static void exchangeElements(int[] array, int index1, int index2) {  
        int temp = array[index1-1];  
        array[index1-1] = array[index2-1];  
        array[index2-1] = temp;  
    }  

//�ҵ����������ֵ
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
