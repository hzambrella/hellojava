package TestCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//�����������
//  2  2  ������к���
//  1 1  ����ĵ�һ��
//  2 3  ����ĵڶ���
public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int x;
		int y;
		System.out.println("�����������������س�ȷ��:");
		x=Integer.valueOf(scanner.nextLine().trim());
		
		System.out.println("�����������������س�ȷ��:");
		y=Integer.valueOf(scanner.nextLine().trim());

		Integer[][]matrix=new Integer[x][y];
		for (int i=0;i<x;i++){
			System.out.println("��������"+(i+1)+"�� (ÿ��"+y+"������)���ո�ֿ����س�ȷ��");
			String[]line=scanner.nextLine().split(" ");
			for(int j=0;j<y;j++){
				matrix[i][j]=Integer.valueOf(line[j]);
			}
		}
		
		//ctrl+z �ر�
		scanner.close();
		System.out.println(Arrays.deepToString(matrix));
	}
}
