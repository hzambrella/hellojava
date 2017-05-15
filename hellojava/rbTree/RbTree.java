// 红黑树
// 镜像问题要注意
// 书上的版本null用哨兵结点nil[T]来替换。
// if-else嵌套，如果太混乱用continue
// 建立：RbTree
// 插入：insertRb。修复insertFixRb
// 查找： rbSearch
// 打印：print
// 遍历: midOB
// 删除： rbDelete。修复deleteFixRb
// 前驱： successor
// 最小元素：miniNode
// 最大元素：maxiNode
package hellojava.rbTree;

// 自己写的打印数组用的
import hellojava.arrayUtils.Arrayutils;

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

	// 建立树
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

	// 插入
	public void insertRb(int i) {
		Node node = new Node(i);
		Node y = null; // 跟踪父节点
		Node x = this.root;// 跟踪插入点，是叶子
		while (x != null) {
			y = x;
			if (node.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
			node.parent = y;
		}
		if (y == null) { // 插入点x是根结点
			this.root = node;
		} else if (node.key < y.key) {
			y.left = node;
		} else {
			y.right = node;
		}
		node.color = -1;
		insertFixRb(node);
	}

	// insert只会违反两种性质:根结点为红或者红结点的子女也是红。
	// 犯得错误：if-else嵌套混乱
	// 镜像问题:z.p是z.grandp的右子时怎么旋转
	// 马虎：颜色更新
	private void insertFixRb(Node z) {
		while (isRed(z.parent)) { // 出错
			Node y; // 叔结点
			// z.p是z.grandp的左子
			if (z.parent == z.parent.parent.left) {
				y = z.parent.parent.right;
				// case 1叔结点的颜色为红色
				// 叔结点和父节点的颜色设为黑色，爷结点为红色，迭代
				if (isRed(y)) {
					y.color = 1;
					z.parent.color = 1;
					z.parent.parent.color = -1;
					z = z.parent.parent;
				} else {

					if (z == z.parent.right) {
						// case 2 叔结点的颜色为黑色，且结点是父节点的右结点
						z = z.parent;// 左旋后，子结点上去了，父节点下去了
						leftRotary(z); // 左旋，转化为case 3
					}

					// case 3 叔结点的颜色为黑色，且结点是父节点的左结点
					z.parent.color = 1;
					z.parent.parent.color = -1;
					rightRotary(z.parent.parent);
				}

				// z.p是z.grandp的右子
			} else {
				y = z.parent.parent.left;// change it

				// case 1叔结点的颜色为红色
				// 叔结点和父节点的颜色设为黑色，爷结点为红色，迭代

				if (isRed(y)) {
					y.color = 1;
					z.parent.color = 1;
					z.parent.parent.color = -1;
					z = z.parent.parent;

				}

				else {
					// case 2 叔结点的颜色为黑色，且结点是父节点的右结点
					if (z == z.parent.left) {
						z = z.parent;// 左旋后，子结点上去了，父节点下去了
						rightRotary(z); // 左旋，转化为case 3
					}
					// case 3 叔结点的颜色为黑色，且结点是父节点的左结点
					z.parent.color = 1;
					z.parent.parent.color = -1;

					leftRotary(z.parent.parent);
				}
			}
		}
		this.root.color = 1;
	}

	// 左旋
	private void leftRotary(Node x) {
		Node y = x.right;
		// 第一步：y的左子变为x的右子，y被x抛弃
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}

		// 第二步，y取代了x

		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.parent = x.parent;

		// 第三步，y吞并x，使其成为被夺走的左子
		y.left = x;
		x.parent = y;
	}

	// 右旋
	private void rightRotary(Node x) {
		Node y = x.left;
		// 第一步：y的右子变为x的左子，y被x抛弃
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}

		// 第二步，y取代了x

		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.parent = x.parent;

		// 第三步，y吞并x，使其成为被夺走的左子
		y.right = x;
		x.parent = y;

	}

	// 显示红黑树
	public void print() {
		if (this.root == null) {
			System.out.println("空树");
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

	// 中序遍历
	public void midOBPrint(Node node) {
		System.out.print("中序遍历: {");
		midOB(node);
		System.out.print("}\n");
	}

	private void midOB(Node node) {
		if (node != null) {
			midOB(node.left);
			System.out.print(node.key + ",");
			midOB(node.right);
		}
	}

	// 以n为根结点查找
	public Node rbSearch(Node n, int k) {
		while (n != null && k != n.key) {
			if (n.key > k) {
				rbSearch(n.left, k);
			} else {
				rbSearch(n.right, k);
			}
		}
		return n;
	}

	// 删除
	public void rbDelete(int i) {
		Node node = new Node(i);
		// 查找 z;
		if (rbSearch(this.root, i) == null) {
			System.out.println("结点不存在");
			return;
		}
		rbDeleteNode(node);
	}

	private void rbDeleteNode(Node z) {

		// 第一步：确定删除结点y
		Node y, x;
		if (z.left == null || z.right == null) {
			y = z;
		} else {
			y = successor(z);
		}
		// 第二步：确定y的子结点x。
		// 有个定理：如果二叉查找树的某个结点有两个子女，其前驱没有右子树，后继没有左子树。
		// 所以在情况三当中，后继不会是两个子结点
		if (y.left != null) {
			x = y.left;
		} else {
			x = y.right;
		}
		// 第三步：x!=nil，修改x.parent为y.parent（书上版本是无条件调用）
		if (x != null) {
			x.parent = y.parent;
		}
		// 第四步：更新y.parent的left或right为x
		// 若y.parent不存在,更新tree.root为x
		if (y.parent == null) {
			this.root = x;
		} else if (y == y.parent.left) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		// 第五步：修改z.key=y.key(若在确定y时，y=z，这步没造成什么改变)，若有卫星数据，修改相关信息。
		z.key = y.key;
		// 第六部： 修复红黑树
		// 如果y.color 为红。不会影响性质，所以不修复。
		if (y.color == 1) {
			deleteFixRb();
		}
	}

	// 修复刪除后的红黑树
	private void deleteFixRb() {
       
	}

	// x的后继
	public Node successor(Node x) {
		// case1:x有右子树，找右子树的最小结点
		if (x.right != null) {
			return miniNode(x.right);
		}
		Node y = x.parent;
		// case2:x木有右子树，向上找，直到某个点y是y.parent.left或nil为止
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	// node为根的树最小元素
	public Node miniNode(Node node) {
		while (node != null) {
			node = node.left;
		}
		return node;
	}

	// node为根的树的最大元素
	public Node maxiNode(Node node) {
		while (node != null) {
			node = node.right;
		}
		return node;
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 4, 6, 5, 7, 8, 10, 9, 1 };
		Arrayutils.printArray(data);
		RbTree tree = new RbTree(data);
		tree.print();
		tree.midOBPrint(tree.root);
	}

}