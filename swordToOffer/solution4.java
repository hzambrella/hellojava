package swordToOffer;
import java.util.*;
public class solution4 {

		public static void main(String[] args) {
			solution4 test=new solution4();
			int[] num={2,3,4,2,6,2,5,1};
			System.out.println(test.maxInWindows(num, 3));
		}
	    //���ϵķ���
	    public ArrayList<Integer> maxInWindows(int [] num, int size){
	        ArrayList<Integer>list=new ArrayList<>();
	        if (size<=0){
	           return list; 
	        }else if(size>num.length){
	            //size=num.length();
	            return list; 
	        }
	        LinkedList<Integer>deque=new LinkedList<>();
	        
	        //�ȷ���ǰsize��Ԫ�أ��������ǽ�������
	        for (int i=0;i<size;i++){
	            //�Ӷ��׿�ʼ���������Сֵ
	            while(!deque.isEmpty()&&num[i]>num[deque.getFirst()]){
	                deque.removeFirst();
	            }
	            
	            //�����β
	            deque.add(i);
	        }
	        
	        for(int i=size;i<num.length;i++){
	            list.add(num[deque.getFirst()]);
	            //�����ϴ��Ƿ�ʧЧ
	            if(!deque.isEmpty()&&deque.getFirst()+size<=i){
	                //ʧЧ
	                deque.removeFirst();
	            }
	            
	            //�Ӷ��׿�ʼ���������Сֵ
	           while(!deque.isEmpty()&&num[i]>num[deque.getFirst()]){
	                deque.removeFirst();
	            }
	           //�����β
	           deque.add(i);
	           System.out.println(deque);
	        }
	        //���һ������
	        list.add(num[deque.getFirst()]);
	        return list;
	    }
	    /* �ҵķ���
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

