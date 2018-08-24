package dataStructurePractice.sort;

import java.util.*;


public class InsertSortV2 {
	
	public static void main(String[] args) {
		InsertSortV2 test=new InsertSortV2();
		int[] array={1};

		
		test.third(new int[]{4,5,1,3,6,2});
//		test.third(new int[]{2,1});
	}
	 public int third(int[] array){
	       int[] copy=new int[array.length];
	       System.arraycopy(array,0,copy,0,array.length);
	       mergeSort(0,array.length-1,array,copy);
	       System.out.println(Arrays.toString(array));
	       System.out.println(Arrays.toString(copy));
	       return 0;
	    }
	    
	    public void mergeSort(int start,int end,int[] src,int[] des){
	        if (start>=end){
	        	 System.out.println("!!!!");
	            return;
	        }
	        
	        mergeSort(start,(start+end)/2,des,src);
	        mergeSort((start+end)/2+1, end,des,src);
	        
	        int first=start;
	        int second=(start+end)/2+1;
	        int i=start;
	        
	        while(first<=(start+end)/2&&second<=end){
	            if (src[first]>src[second]){
	                des[i]=src[second];
	                second++;
	            }else{
	                des[i]=src[first];
	                first++;
	            }
	            i++;
	        }
	        
	        while(first<=(start+end)/2){
	            des[i]=src[first];
	            first++;
	            i++;
	        }
	        
	         while(second<=end){
	            des[i]=src[second];
	            second++;
	            i++;
	        }
	    }
	    
}	
