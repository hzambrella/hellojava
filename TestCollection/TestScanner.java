package TestCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//需求：输入矩阵
//  2  2  矩阵的行和列
//  1 1  矩阵的第一行
//  2 3  矩阵的第二行
public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int x;
		int y;
		System.out.println("输入矩阵的行数，按回车确认:");
		x=Integer.valueOf(scanner.nextLine().trim());
		
		System.out.println("输入矩阵的列数，按回车确认:");
		y=Integer.valueOf(scanner.nextLine().trim());

		Integer[][]matrix=new Integer[x][y];
		for (int i=0;i<x;i++){
			System.out.println("输入矩阵第"+(i+1)+"行 (每行"+y+"个数据)，空格分开，回车确认");
			String[]line=scanner.nextLine().split(" ");
			for(int j=0;j<y;j++){
				matrix[i][j]=Integer.valueOf(line[j]);
			}
		}
		
		//ctrl+z 关闭
		scanner.close();
		System.out.println(Arrays.deepToString(matrix));
	}
}
