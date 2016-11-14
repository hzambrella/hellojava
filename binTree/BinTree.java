//  ���������
package binTree;

public class BinTree {
	// ���ĸ�
	Node root = null;

	// ���ࡣ���⼸�����֣�key������ӵ㣬�Ҷ��ӵ㣬���ڵ�
	private class Node {
		Node parent = null;
		Node leftChild = null;
		Node rightChild = null;
		int key;

		// ���캯��
		public Node(int data) {
			this.key = data;
		}

	}

	// ���캯��
	public BinTree(int[] datas) {
		buildTree(datas);
	}

	// ������
	private void buildTree(int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			Node node = new Node(datas[i]);
			insertNode(node);
		}
	}

	// ������
	private void insertNode(Node node) {
		Node next = this.root;// ����·��
		Node cur = null; // �������浱ǰ��㣬ʼ����next�ĸ��ڵ㣬�������node�ĸ��ڵ㡣
		while (next != null) { // ֱ������Ҷ�ӽ��
			cur = next;
			if (node.key >= cur.key) {
				next = next.rightChild;// �����ұ�
			} else {
				next = next.leftChild;// �������
			}
		}
		node.parent = cur; // ����ý��
		if (cur == null) { // this.rootΪ�գ�nextΪ�ա�curҲ�Ϳ���
			this.root = node; // ����Ϊ��������������Ǹ��ڵ�
		} else if (node.key >= cur.key) {
			cur.rightChild = node;
		} else {
			cur.leftChild = node;
		}
	}

	// ����һ����
	public void insert(int data) {
		Node node = new Node(data);
		System.out.println("�����㣺" + data);
		insertNode(node);
		this.midOrderTraverse();
	}
	
	// �������������
    public void midOrderTraverse() {
		System.out.println("���������");
		midOrderTraverse(root);
		System.out.println();
	}

	// �������,��node��ʼ
	private void midOrderTraverse(Node node) {
		if (node != null) {
			midOrderTraverse(node.leftChild);
			System.out.print("-" + node.key + "-");
			midOrderTraverse(node.rightChild);
		}
	}

	// ����
	public Node search(Node x, int data) {
		System.out.println("��Ҫ���ҵ��ǣ�" + data);

		if (x == null || data == x.key) {
			return x;
		}
		if (data < x.key) {
			return search(x.leftChild, data);
		} else {
			return search(x.rightChild, data);
		}
	}

	// ɾ�����
    public void delete(int data) {
		Node y;
		Node x;
		Node z = search(this.root, data);
		if (z == null) {
			System.out.println("û�ҵ�"+data);
			return;
		}
		// ����Ҫ�h���ĵ�y
		if (z.leftChild == null || z.rightChild == null) {
			y = z;    
		} else {
			y = predecessor(z);// ��������Ϊ��ʱ���Ѻ���ƶ���Ҫɾ���ĵ��ϣ�
		}
		
		// ����Ҫɾ���ĵ�y���ӽ��x
		// �и�������������������ĳ�������������Ů����ǰ��û�������������û����������
		// ��������������У���̲����������ӽ��
		if (y.leftChild != null) {
			x = y.leftChild;
		} else {
			x = y.rightChild;
		}
		
		// ��x���ڣ���x��parentָ��ָ��y.parent
		if (x != null) {
			x.parent = y.parent;
		}
		
        // ���y�Ǹ����
		if (y.parent == null) {
			this.root = x;
		} else if (y == y.parent.leftChild) {
			y.parent.leftChild = x;
		}else{
			y.parent.rightChild=x;
		}
		
		if (y!=x){
			z.key=y.key;
			// ������������ݵĻ���ӳ�䡣
		}
		midOrderTraverse();
	}

	/*
	 * ��ȡ��̽��
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

	// ��СԪ�صĵ�
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