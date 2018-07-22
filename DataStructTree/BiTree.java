package DataStructTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

//二叉树的链式存储
public class BiTree<T> {
	//根节点
	private BiTreeNode<T>root;
	
	public BiTree(){
		super();
	}
	
	//扩展二叉树的形式建立树
//	public BiTree(T[] datas){
//		ArrayDeque<T> dataqueue=new ArrayDeque<>();
//		for (T data:datas){
//			dataqueue.add(data);
//		}
//
//		this.root=createTreeNode(this.root,dataqueue);
//	}
	
	public BiTree(LinkedList<T> dataqueue){
		this.root=createTreeNode(this.root,dataqueue);
	}
	
	public BiTree(T data){
		this.root=new BiTreeNode<T>(data);
	};

	public BiTreeNode<T> getRoot() {
		return root;
	}
	
	//扩展二叉树
	private BiTreeNode<T> createTreeNode(BiTreeNode<T> node,LinkedList<T> datas){
		if (datas.size()==0){
			return null;
		}
		T data=datas.pop();
		
		if (data==null){
			node=null;
		}else{
			node=new BiTreeNode<T>(data);
			node.setLeftChild(createTreeNode(node.getLeftChild(),datas));
			node.setRightChild(createTreeNode(node.getRightChild(),datas));
		}
		return node;
	}
	
	//前序遍历
	public String preOrderTraverse(){
		ArrayDeque<BiTreeNode<T>> queue=new ArrayDeque<>();
		preOrderTraverseForNode(this.root,queue);

		return queue.toString();
	}
	
	private void preOrderTraverseForNode(BiTreeNode<T> node,ArrayDeque<BiTreeNode<T>> queue){
		if (node==null){
			return;
		}
		queue.add(node);
		preOrderTraverseForNode(node.getLeftChild(),queue);
		preOrderTraverseForNode(node.getRightChild(),queue);
	}
	
	//中序遍历
	public String midOrderTraverse(){
		ArrayDeque<BiTreeNode<T>> queue=new ArrayDeque<>();
		midOrderTraverseForNode(this.root,queue);

		return queue.toString();
	}
	
	private void midOrderTraverseForNode(BiTreeNode<T> node,ArrayDeque<BiTreeNode<T>> queue){
		if (node==null){
			return;
		}
		midOrderTraverseForNode(node.getLeftChild(),queue);
		queue.add(node);
		midOrderTraverseForNode(node.getRightChild(),queue);
	}
}
