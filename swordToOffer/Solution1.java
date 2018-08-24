package swordToOffer;
import java.util.*;

public class Solution1 {
	
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(8);
		TreeNode t2=new TreeNode(6);
		TreeNode t3=new TreeNode(10);
		TreeNode t4=new TreeNode(5);
		TreeNode t5=new TreeNode(7);
		TreeNode t6=new TreeNode(9);
		TreeNode t7=new TreeNode(1);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		System.out.println(new Solution1().Print(t1));
	}
	
	
	 ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	        ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
	        LinkedList<TreeNode>queue1=new LinkedList<>();
	        LinkedList<TreeNode>queue2=new LinkedList<>();
	        LinkedList<TreeNode> fqueue=queue1;
	        LinkedList<TreeNode> cqueue=queue2;
	        fqueue.add(pRoot);
	        boolean isFirst=true;
	        ArrayList<Integer>list=new ArrayList<>();
	        while(!(queue1.isEmpty()&&queue2.isEmpty())){
	            TreeNode node=fqueue.pop();
	            System.out.println(node);
	            list.add(node.val);
	            if (node.left!=null){
	                cqueue.add(node.left);
	            }
	            if (node.right!=null){
	               cqueue.add(node.right);
	            }
	            
	            System.out.println(queue1);
	            System.out.println(queue2);
	            
	            if (fqueue.isEmpty()){
	                result.add(list);
	                list=new ArrayList<Integer>();
	                if (isFirst){
	                    fqueue=queue2;
	                    cqueue=queue1;
	                }else{
	                    fqueue=queue1;
	                    cqueue=queue2;
	                }
	                isFirst=!isFirst;
	            }
	        }
	        return result;
	    }
}
