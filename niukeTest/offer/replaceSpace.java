package niukeTest.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class replaceSpace {
	public static void main(String[] args) {
		
	}
	
    public String replaceSpace(StringBuffer str) {
    	String strobj=str.toString();
        return strobj.replace(" ","%20");
    }
    
//    public class Solution {
//        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//            ArrayList<Integer> list1=new ArrayList<Integer>();
//            ArrayList<Integer> list2=new ArrayList<Integer>();
//            while(listNode!=null){
//                list1.add(listNode.val);
//                listNode=listNode.next;
//            }
//            
//            int length=list1.size();
//            Integer[] li=new Integer[length];
//            for (int i=0;i<length;i++){
//                li[length-i-1]=list1.get(i);
//            }
//            return (ArrayList<Integer>) Arrays.asList(li);
//        }
//    }
}
