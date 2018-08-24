package swordToOffer;

public class solutioin2 {
		public static void main(String[] args) {
			TreeNode t1=new TreeNode(1);
			TreeNode t2=new TreeNode(2);
			TreeNode t3=new TreeNode(3);
			TreeNode t4=new TreeNode(4);
			TreeNode t5=new TreeNode(5);
			TreeNode t6=new TreeNode(6);
			TreeNode t7=new TreeNode(7);
			t1.left=t2;
			t1.right=t3;
			t2.left=t4;
			t2.right=t5;
			t3.left=t6;
			t3.right=t7;
			solutioin2 test=new solutioin2();
			String str=test.Serialize(t1);
			TreeNode node=test.Deserialize(str);
		}
	
	
	    String Serialize(TreeNode root) {
	        StringBuffer buf=new StringBuffer();
	        if(root==null){
	            return "#,";
	        }else{
	            buf.append(root.val);
	            buf.append(",");
	            buf.append(Serialize(root.left));
	            buf.append(Serialize(root.right));
	        }
	        return buf.toString();
	    }
	    int index=0;
	    TreeNode Deserialize(String str) {
	        String[] list=str.split(",");
	        if(list==null||list.length==0||list[0]=="#"){
	            return null;
	        }
	        TreeNode root=new TreeNode(Integer.valueOf(list[0]));
	        index++;
	        root.left=generate(list);
	        root.right=generate(list);
	        return root;
	    }
	    
	    TreeNode generate(String[] list){
	       // if (list[index]=="#"||list[index]==" "){
	    	 if (list[index].equals("#")||list[index].equals(" ")){
	            index++;
	            return null;
	        }

	        
	        TreeNode root=new TreeNode(Integer.valueOf(list[index]));
	        index++;
	        root.left=generate(list);
	        root.right=generate(list);
	        return root;
	    }
}

