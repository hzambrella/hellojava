package dataStructurePractice.search;

import java.util.ArrayList;

//二叉搜索树
//里面元素按照升序排列
public class BST <T extends Comparable<T>> {
	TreeNode<T> root;
	
	public BST(T rootVal){
		root=new TreeNode<T>(rootVal);
	}
	
	
	//查找元素
	public boolean search(T val){
		return search(val,root);
	}
	
	//查找元素
	private boolean search(T val,TreeNode<T> node){
		if (node==null){
			return false;
		}
		boolean result=false;
		if(val.compareTo(node.val)<0){
			result=search(val,node.left);
		}else if( val.compareTo(node.val)>0){
			result=search(val,node.right);
		}else{
			result=true;
		}
			
		return result;
	}
	
	//添加元素
	public boolean add(T val){
		//元素已经存在。返回false。
		if (search(val)){
			return false;
		}
		
		TreeNode<T> toInsert=root;
		int where=0;
		TreeNode<T>lastSearch=root;
		
		while(toInsert!=null){
			if (val.compareTo(toInsert.val)<0){
				lastSearch=toInsert;
				toInsert=toInsert.left;
				where=0;
			}else if (val.compareTo(toInsert.val)>0){
				lastSearch=toInsert;
				toInsert=toInsert.right;
				where=1;
			}else{
				return false;
			}
		}
		
		if (where==0){
			lastSearch.left=new TreeNode<T>(val);
		}else{
			lastSearch.right=new TreeNode<T>(val);
		}
		
		return true;
	}
	
	//删除元素:TODO 很麻烦
	public boolean delete(T val){
		if (search(val)){
			return false;
		}
		
		
		
		return false;
	}
	
	
	//打印二叉搜索树。采用中根遍历。
	public String toString(){
		ArrayList<T> list=new ArrayList<>();
		midSearch(root,list);
		return list.toString();
	}
	
	public void midSearch(TreeNode<T> node,ArrayList<T> result){
		if (node==null){
			return;
		}
		midSearch(node.left,result);
		result.add(node.val);
		midSearch(node.right,result);
	}
	
	public static void main(String[] args) {
		BST<Integer> bst=new BST<Integer>(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		bst.add(7);
		bst.add(8);
		bst.add(9);
		System.out.println(bst);
		System.out.println(bst.search(6));
		System.out.println(bst.search(16));
	}
}
