package niukeTest.offer;

import java.util.ArrayList;

public class Matrix {
	static int a=0;
	
	public static void main(String[] args) {
		Matrix m=new Matrix();
		int [][] matrix={{1,2,3,4,5}};
		m.printMatrix(matrix);	
	}
	
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int startRow=0;
       int endRow=matrix.length-1;
       int startCol=0;
       int endCol=matrix[0].length-1;
        ArrayList<Integer> list =new ArrayList<Integer>();
        
        while((startRow<=endRow&&startCol<=endCol)){
    
            for(int i=startCol;i<=endCol;i++){
                list.add(matrix[startRow][i]);
                System.out.println(list);
            }
            
            if (startRow+1<=endRow-1){
                for (int i=startRow+1;i<=endRow-1;i++){
                     list.add(matrix[i][endCol]);
                     System.out.println(list);
                } 
            }

            
            if (startRow!=endRow){
                for (int i=endCol;i>=startCol;i--){
                    list.add(matrix[endRow][i]);
                    System.out.println(list);
                } 
            }
            
            if (startRow+1<=endRow-1){
                for (int i=endRow-1;i>=startRow+1;i--){
                    list.add(matrix[i][startCol]);
                    System.out.println(list);
                } 
            }

            
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return list;
    }
 }
