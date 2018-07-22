package dataStructurePractice.search;

import java.util.ArrayList;

//����������
//����Ԫ�ذ�����������
public class BST <T extends Comparable<T>> {
	TreeNode<T> root;
	
	public BST(T rootVal){
		root=new TreeNode<T>(rootVal);
	}
	
	
	//����Ԫ��
	public boolean search(T val){
		return search(val,root);
	}
	
	//����Ԫ��
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
	
	//���Ԫ��
	public boolean add(T val){
		//Ԫ���Ѿ����ڡ�����false��
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
	
	//ɾ��Ԫ��:TODO ���鷳
	public boolean delete(T val){
		if (search(val)){
			return false;
		}
		
		
		
		return false;
	}
	
	
	//��ӡ�����������������и�������
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
