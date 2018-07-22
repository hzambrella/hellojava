package DataStructTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

//����������ʽ�洢
public class BiTree<T> {
	//���ڵ�
	private BiTreeNode<T>root;
	
	public BiTree(){
		super();
	}
	
	//��չ����������ʽ������
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
	
	//��չ������
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
	
	//ǰ�����
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
	
	//�������
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
