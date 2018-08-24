package swordToOffer;
import java.util.*;
public class solution4 {

		public static void main(String[] args) {
			solution4 test=new solution4();
			int[] num={2,3,4,2,6,2,5,1};
			System.out.println(test.maxInWindows(num, 3));
		}
	    //书上的方法
	    public ArrayList<Integer> maxInWindows(int [] num, int size){
	        ArrayList<Integer>list=new ArrayList<>();
	        if (size<=0){
	           return list; 
	        }else if(size>num.length){
	            //size=num.length();
	            return list; 
	        }
	        LinkedList<Integer>deque=new LinkedList<>();
	        
	        //先放入前size个元素，并对它们进行整理。
	        for (int i=0;i<size;i++){
	            //从队首开始，清空所有小值
	            while(!deque.isEmpty()&&num[i]>num[deque.getFirst()]){
	                deque.removeFirst();
	            }
	            
	            //放入队尾
	            deque.add(i);
	        }
	        
	        for(int i=size;i<num.length;i++){
	            list.add(num[deque.getFirst()]);
	            //队首老大是否失效
	            if(!deque.isEmpty()&&deque.getFirst()+size<=i){
	                //失效
	                deque.removeFirst();
	            }
	            
	            //从队首开始，清空所有小值
	           while(!deque.isEmpty()&&num[i]>num[deque.getFirst()]){
	                deque.removeFirst();
	            }
	           //放入队尾
	           deque.add(i);
	           System.out.println(deque);
	        }
	        //最后一个窗口
	        list.add(num[deque.getFirst()]);
	        return list;
	    }
	    /* 我的方法
	    public ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
	        // 1 2 3 4 5             5-3=2
	         ArrayList<Integer>list=new ArrayList<>();
	        if (size<=0){
	           return list; 
	        }else if(size>num.length){
	            //size=num.length();
	            return list; 
	        }

	        for(int i=size-1;i<num.length;i++){
	            list.add(max(num,i,size));
	        }
	        return list;
	    }
	    
	    int max (int [] num, int index,int size){
	        int max=num[index];
	        for (int i=index-1;i>index-size;i--){
	            if (num[i]>max){
	                max=num[i];
	            }
	        }
	        return max;
	    }
	    */
	}

