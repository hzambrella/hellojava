//  二叉查找树
package binTree;

public class BinTree {
	// 树的根
	Node root = null;

	// 点类。有这几个部分：key域，左儿子点，右儿子点，父节点
	private class Node {
		Node parent = null;
		Node leftChild = null;
		Node rightChild = null;
		int key;

		// 构造函数
		public Node(int data) {
			this.key = data;
		}

	}

	// 构造函数
	public BinTree(int[] datas) {
		buildTree(datas);
	}

	// 建立树
	private void buildTree(int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			insertNode(node);
		}
	}

	// 插入结点
	private void insertNode(Node node) {
		Node next = this.root;// 跟踪路径
		Node cur = null; // 用来保存当前结点，始终是next的父节点，即插入点node的父节点。
		while (next != null) { // 直到到达叶子结点
			cur = next;
			if (node.key >= cur.key) {
				next = next.rightChild;// 飞向右边
			} else {
				next = next.leftChild;// 飞向左边
			}
		}
		node.parent = cur; // 插入该结点
		if (cur == null) { // this.root为空，next为空。cur也就空了
			this.root = node; // 该树为空树，所以这个是根节点
		} else if (node.key >= cur.key) {
			cur.rightChild = node;
		} else {
			cur.leftChild = node;
		}
	}

	// 插入一个数
	public void insert(int data) {
		Node node = new Node(data);
		System.out.println("插入结点：" + data);
		insertNode(node);
		this.midOrderTraverse();
	}
	
	// 中序遍历整个树
    public void midOrderTraverse() {
		System.out.println("中序遍历：");
		midOrderTraverse(root);
		System.out.println();
	}

	// 中序遍历,从node开始
	private void midOrderTraverse(Node node) {
		if (node != null) {
			midOrderTraverse(node.leftChild);
			System.out.print("-" + node.key + "-");
			midOrderTraverse(node.rightChild);
		}
	}

	// 查找
	public Node search(Node x, int data) {
		System.out.println("您要查找的是：" + data);

		if (x == null || data == x.key) {
			return x;
		}
		if (data < x.key) {
			return search(x.leftChild, data);
		} else {
			return search(x.rightChild, data);
		}
	}

	// 删除结点
    public void delete(int data) {
		Node y;
		Node x;
		Node z = search(this.root, data);
		if (z == null) {
			System.out.println("没找到"+data);
			return;
		}
		// 设置要刪除的点y
		if (z.leftChild == null || z.rightChild == null) {
			y = z;    
		} else {
			y = predecessor(z);// 子树都不为空时，把后继移动到要删除的点上，
		}
		
		// 设置要删除的点y的子结点x
		// 有个定理：如果二叉查找树的某个结点有两个子女，其前驱没有右子树，后继没有左子树。
		// 所以在情况三当中，后继不会是两个子结点
		if (y.leftChild != null) {
			x = y.leftChild;
		} else {
			x = y.rightChild;
		}
		
		// 若x存在，将x的parent指针指向y.parent
		if (x != null) {
			x.parent = y.parent;
		}
		
        // 如果y是根结点
		if (y.parent == null) {
			this.root = x;
		} else if (y == y.parent.leftChild) {
			y.parent.leftChild = x;
		}else{
			y.parent.rightChild=x;
		}
		
		if (y!=x){
			z.key=y.key;
			// 如果有卫星数据的话，映射。
		}
		midOrderTraverse();
	}

	/*
	 * 获取后继结点
	 */
	public Node predecessor(Node x) {
		if (x.leftChild != null) {
			return minimum(x);
		}
		Node y = x.parent;
		while (y != null && x == y.leftChild) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	// 最小元素的点
	public Node minimum(Node x) {
		while (x.leftChild != null) {
			x = x.leftChild;
		}

		return x;
	}

	public static void main(String args[]) {
		int[] datas = { 3,5,6,7,8,10,12,13,15,16,18,20,23 };
		BinTree tree = new BinTree(datas);
		tree.delete(5);
	}
}