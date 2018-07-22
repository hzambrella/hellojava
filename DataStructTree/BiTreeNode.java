package DataStructTree;

//�������Ľڵ�
public class BiTreeNode<T> {
//	//�ڵ�Ϊ��
//	public static BiTreeNode<?> NullBiTreeNode;
//	
//	public synchronized BiTreeNode<?> getNullBiTreeNodeInstance(){
//		if(NullBiTreeNode==null){
//			NullBiTreeNode=new BiTreeNode<Object>();
//		}
//		return NullBiTreeNode;
//	}
	
	private BiTreeNode<T> leftChild;
	private BiTreeNode<T> rightChild;
	private T data;
	
	public BiTreeNode(){
		super();
	}
	
	public BiTreeNode(BiTreeNode<T> leftChild,BiTreeNode<T> rightChild,T data){
		this.leftChild=leftChild;
		this.rightChild=rightChild;
		this.data=data;
	}
	
	public BiTreeNode(T data){
		this.data=data;
	}
	
	public BiTreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(BiTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public BiTreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BiTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public String toString(){
		return this.data.toString();
	}
	
}
