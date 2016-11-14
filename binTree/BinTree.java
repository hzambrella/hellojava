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
	// 中序遍历

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

	// 搜索结点
	public void searchNode(int data) {
		Node x = this.root;
		if (x == null) {
			System.out.println("空树");

		} else if (search(x, data) == null) {
			System.out.println("没找到");
		} else {
			System.out.println("查找" + search(x, data).key + "成功");
		}
	}

	// 查
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
		Node node;
		Node x = this.root;
		if ((node = search(x, data)) == null) {
			System.out.println("二叉树中不存在此结点！");
			return;
		}
		deleteNode(node);
		System.out.println("删除结点" + data + "后：");
		this.midOrderTraverse();
	}

	private void deleteNode(Node node) {
		if (node == null) {
			System.out.println("删除结点不能为空！");
			return;
		}
		replacedNode(node);
	}

	private void replacedNode(Node node) { // 替换结点
		if (node.leftChild != null && node.rightChild != null) { // 当有左右孩子时，用后继结点替换
			replacedNodeOfPost(node);
		} else {
			if (node.leftChild != null) { // 当只有左孩子时，直接用左子树替换
				node = node.leftChild;
			} else if (node.rightChild != null) { // 只有右孩子时，直接有子树替换
				node = node.rightChild;
			} else { // 当没有左右孩子时，就直接释放了这个结点
				freeNode(node);
			}
		}
	}

	private void freeNode(Node node) { // 释放该结点，断掉其与父结点的链接
		if (node == node.parent.leftChild) {
			node.parent.leftChild = null;
		} else {
			node.parent.rightChild = null;
		}
	}

	private void replacedNodeOfPost(Node node) {
		Node y = this.predecessor(node); // 找后继结点
		node.key = y.key;
		replacedNode(y); // 替换了key之后，再一次递归把现在这个结点给替换了！
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
		int[] datas = { 12, 4, 5, 7, 4, 8, 3, 2, 6, 9 };
		BinTree tree = new BinTree(datas);
		tree.insert(10);
		tree.search(tree.root, 12);
		tree.delete(5);
	}
}