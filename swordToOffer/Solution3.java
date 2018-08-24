package swordToOffer;

public class Solution3 {
	 TreeNode result;
	 
		public static void main(String[] args) {
			TreeNode t1=new TreeNode(8);
			TreeNode t2=new TreeNode(6);
			TreeNode t3=new TreeNode(10);
			TreeNode t4=new TreeNode(5);
			TreeNode t5=new TreeNode(7);
			TreeNode t6=new TreeNode(9);
			TreeNode t7=new TreeNode(11);
			t1.left=t2;
			t1.right=t3;
			t2.left=t4;
			t2.right=t5;
			t3.left=t6;
			t3.right=t7;
			Solution3 test=new Solution3();

			TreeNode node=test.KthNode(t1,3);
			System.out.println(node);
		}
		
	    int index=0;
	     TreeNode KthNode(TreeNode pRoot,int k){
	         if(pRoot==null||k<1){
	             return null;
	         }
	        TreeNode node=KthNode(pRoot.left,k);
	        System.out.println(pRoot+"-"+index+"-"+node);
	        
	        if(node!=null){
	            return node;
	        }
	        index=index+1;
	        if (index==k){
	            return pRoot;
	        }else{
	            return KthNode(pRoot.right,index);
	        }
	       
	     }
		
		
	 /*
	    TreeNode KthNode(TreeNode pRoot, int k){    
	        if (k<1){
	            return null;
	        }
	        
	        if (pRoot==null){
	            return null;
	        }
	        search(pRoot,1,k);
	        return result;
	    }
	    
	    int search(TreeNode node,int index,int k){
	        if (node==null||k<1||index==-1){
	            return index;
	        }
	        int now=search(node.left,index,k);
	        System.out.println(now+"-"+node);
	        if(now==-1){
	            return -1;
	        }else if(now==k){
	            result=node;
	            return -1;
	        }else{
	            return search(node.right,now+1,k);
	        }
	    }
	    */
}
