// �����
// ��������Ҫע��
// if-elseǶ�ף����̫������continue
// ������RbTree
// ���룺insertRb
// ��ӡ��print
// ������
package rbTree;

import arrayUtils.Arrayutils;

public class RbTree {
	Node root = null;

	private class Node {
		Node parent;
		Node left;
		Node right;
		int color;// RED=false BLACK=true
		int key;

		public Node(int data) {
			this.key = data;
		}
	}

	public RbTree(int[] data) {
		buildRbTree(data);
	}

	// ������
	private void buildRbTree(int[] data) {
		for (int i = 0; i < data.length; i++) {
			insertRb(data[i]);
		}
	}

	private Boolean isRed(Node node) {
		if (node == null) {
			return false;
		}
		return node.color == -1 ? true : false;
	}

	private Boolean isBlack(Node node) {
		if (node == null) {
			return false;
		}
		return node.color == 1 ? true : false;
	}

	// ����
	public void insertRb(int i) {
		Node node = new Node(i);
		Node y = null; // ���ٸ��ڵ�
		Node x = this.root;// ���ٲ���㣬��Ҷ��
		while (x != null) {
			y = x;
			if (node.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
			node.parent = y;
		}
		if (y == null) { // �����x�Ǹ����
			this.root = node;
		} else if (node.key < y.key) {
			y.left = node;
		} else {
			y.right = node;
		}
		node.color = -1;
		insertFixRb(node);
	}

	// insertֻ��Υ����������:�����Ϊ����ߺ������ŮҲ�Ǻ졣
	private void insertFixRb(Node z) {
		while (isRed(z.parent)) { // ����
			Node y; // ����
			// z.p��z.grandp������
			if (z.parent == z.parent.parent.left) {
				y = z.parent.parent.right;
				// case 1�������ɫΪ��ɫ
				// ����͸��ڵ����ɫ��Ϊ��ɫ��ү���Ϊ��ɫ������
				if (isRed(y)) {
					y.color = 1;
					z.parent.color = 1;
					z.parent.parent.color = -1;
					z = z.parent.parent;
				} else {

					if (z == z.parent.right) {
						// case 2 �������ɫΪ��ɫ���ҽ���Ǹ��ڵ���ҽ��
						z = z.parent;// �������ӽ����ȥ�ˣ����ڵ���ȥ��
						leftRotary(z); // ������ת��Ϊcase 3
					}

					// case 3 �������ɫΪ��ɫ���ҽ���Ǹ��ڵ������
					z.parent.color = 1;
					z.parent.parent.color = -1;
					rightRotary(z.parent.parent);
				}

				// z.p��z.grandp������
			} else {
				y = z.parent.parent.left;// change it

				// case 1�������ɫΪ��ɫ
				// ����͸��ڵ����ɫ��Ϊ��ɫ��ү���Ϊ��ɫ������

				if (isRed(y)) {
					y.color = 1;
					z.parent.color = 1;
					z.parent.parent.color = -1;
					z = z.parent.parent;

				}

				else {
					// case 2 �������ɫΪ��ɫ���ҽ���Ǹ��ڵ���ҽ��
					if (z == z.parent.left) {
						z = z.parent;// �������ӽ����ȥ�ˣ����ڵ���ȥ��
						rightRotary(z); // ������ת��Ϊcase 3
					}
					// case 3 �������ɫΪ��ɫ���ҽ���Ǹ��ڵ������
					z.parent.color = 1;
					z.parent.parent.color = -1;

					leftRotary(z.parent.parent);
				}
			}
		}
		this.root.color = 1;
	}

	// ����
	private void leftRotary(Node x) {
		Node y = x.right;
		// ��һ����y�����ӱ�Ϊx�����ӣ�y��x����
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}

		// �ڶ�����yȡ����x

		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.parent = x.parent;

		// ��������y�̲�x��ʹ���Ϊ�����ߵ�����
		y.left = x;
		x.parent = y;
	}

	// ����
	private void rightRotary(Node x) {
		Node y = x.left;
		// ��һ����y�����ӱ�Ϊx�����ӣ�y��x����
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}

		// �ڶ�����yȡ����x

		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.parent = x.parent;

		// ��������y�̲�x��ʹ���Ϊ�����ߵ�����
		y.right = x;
		x.parent = y;

	}

	// ��ʾ�����
	public void print() {
		if (this.root == null) {
			System.out.println("����");
			return;
		}
		printRb(this.root, 0);
	}

	public void printRb(Node node, int direction) {
		if (node != null) {

			if (direction == 0) {
				System.out.printf("%d (%s)is root\n", node.key, isRed(node) ? "RED" : "BLACK");
			} else {
				System.out.printf("%d (%s)is %d 's %s chird node", node.key, isRed(node) ? "RED" : "BLACK",
						node.parent.key, direction == -1 ? "right" : "left");
				System.out.print("\n");
			}

			printRb(node.left, 1);
			printRb(node.right, -1);
		}

	}

	public void midOBPrint(Node node){
		System.out.print("�������: {");
		midOB(node);
		System.out.print("}\n");
	}
	private void midOB(Node node) {
		if (node != null) {
			midOB(node.left);
			System.out.print(node.key+",");
			midOB(node.right);
		}
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 4, 6, 5, 7, 8, 10, 9, 1 };
		Arrayutils.printArray(data);
		RbTree tree = new RbTree(data);
		tree.print();
		tree.midOBPrint(tree.root);
	}

}