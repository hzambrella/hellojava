package testAndtry;

import java.util.Scanner;

public class TestSystemIn2 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while (in.hasNext()){
			int num=in.nextInt();
			System.out.println(num);
		}
		//ctrl+z½áÊø
		in.close();
	}
	
	
	public  static <E> void printArray(E[] array){
		System.out.print("[");
		for (int i=0;i<array.length;i++){
			E el=array[i];
			System.out.print(el);
			if (i!=array.length-1){
				System.out.print(",");
			}
		}
		System.out.print("]\n");
	} 
}
