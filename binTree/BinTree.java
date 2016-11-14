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
	// �������

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

	// �������
	public void searchNode(int data) {
		Node x = this.root;
		if (x == null) {
			System.out.println("����");

		} else if (search(x, data) == null) {
			System.out.println("û�ҵ�");
		} else {
			System.out.println("����" + search(x, data).key + "�ɹ�");
		}
	}

	// ��
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
		Node node;
		Node x = this.root;
		if ((node = search(x, data)) == null) {
			System.out.println("�������в����ڴ˽�㣡");
			return;
		}
		deleteNode(node);
		System.out.println("ɾ�����" + data + "��");
		this.midOrderTraverse();
	}

	private void deleteNode(Node node) {
		if (node == null) {
			System.out.println("ɾ����㲻��Ϊ�գ�");
			return;
		}
		replacedNode(node);
	}

	private void replacedNode(Node node) { // �滻���
		if (node.leftChild != null && node.rightChild != null) { // �������Һ���ʱ���ú�̽���滻
			replacedNodeOfPost(node);
		} else {
			if (node.leftChild != null) { // ��ֻ������ʱ��ֱ�����������滻
				node = node.leftChild;
			} else if (node.rightChild != null) { // ֻ���Һ���ʱ��ֱ���������滻
				node = node.rightChild;
			} else { // ��û�����Һ���ʱ����ֱ���ͷ���������
				freeNode(node);
			}
		}
	}

	private void freeNode(Node node) { // �ͷŸý�㣬�ϵ����븸��������
		if (node == node.parent.leftChild) {
			node.parent.leftChild = null;
		} else {
			node.parent.rightChild = null;
		}
	}

	private void replacedNodeOfPost(Node node) {
		Node y = this.predecessor(node); // �Һ�̽��
		node.key = y.key;
		replacedNode(y); // �滻��key֮����һ�εݹ��������������滻�ˣ�
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
		int[] datas = { 12, 4, 5, 7, 4, 8, 3, 2, 6, 9 };
		BinTree tree = new BinTree(datas);
		tree.insert(10);
		tree.search(tree.root, 12);
		tree.delete(5);
	}
}