package dataStructurePractice.search;

public class TreeNode<T extends Comparable<T>> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T val;
	
	public TreeNode(T val){
		this.val=val;
	}
	
}	
