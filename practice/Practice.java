package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Integer x=Integer.parseInt(scanner.nextLine().trim());
		Integer y=Integer.parseInt(scanner.nextLine().trim());
		Integer[][]matrix=new Integer[x][y];
		for(int i=0;i<x;i++){
			String[] strs=scanner.nextLine().split(" ");
			for (int j=0;j<y;j++){
				matrix[i][j]=Integer.parseInt(strs[j]);
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		scanner.close();
	}
}
