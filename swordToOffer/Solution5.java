package swordToOffer;

import java.util.HashSet;

public class Solution5 {
	
	public static void main(String[] args) {
		Solution5 test=new Solution5();
		String testStr="abcesfcsadee";
		String toFind="bcced";
		char[] matrix=testStr.toCharArray();
		System.out.println(test.hasPath(matrix,3,4,toFind.toCharArray()));
	}
	
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //abce
        //sfcs
        //adee
        if (matrix.length==0&&str.length!=0){
            return false;
        }
        if(str.length==0){
            return true;
        }
        
        //HashSet<Integer> ban=new HashSet<Integer>();
        return find(matrix,rows,cols,str);
    }
    boolean find(char[] matrix, int rows, int cols, char[] str){
        HashSet<Integer> ban=new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++){
            if(dofind(matrix,rows,cols,str,0,i,ban)){
                return true;
            }
            ban.clear();
        }
        return false;
    }
    
    boolean dofind(char[] matrix, int rows, int cols, char[] str,
                   int index,int start,HashSet<Integer>ban){
    	System.out.println(index+"¡ª¡ª"+start+"--"+ban);
    	
        if (start>=matrix.length||start<0){
            return false;
        }
        
        if(ban.contains(start)){
            return false;
        }
        
        if (str[index]==matrix[start]){
            ban.add(start);
            index++;
            if (index>=str.length){
                return true;
            }else{
                int up=start-cols;
                int down=start+cols;
                int front=start+1;
                int back=start-1;
               return dofind(matrix,rows,cols,str,index,up,ban)||
                   dofind(matrix,rows,cols,str,index,down,ban)||
                   dofind(matrix,rows,cols,str,index,front,ban)||
                   dofind(matrix,rows,cols,str,index,back,ban);
            }
        }else{
            return false;
        }
    }

}
