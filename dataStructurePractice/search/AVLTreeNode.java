package dataStructurePractice.search;


public class AVLTreeNode<T extends Comparable<T>> {
	public AVLTreeNode<T> left;
	public AVLTreeNode<T> right;
	public T val;
	public int BF;//ƽ������
	
	public AVLTreeNode(T val){
		this.val=val;
	}
	
	
	
}