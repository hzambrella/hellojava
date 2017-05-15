// 分销模型：显示出某个点的1.2.3子级的数量,关系是:父子（上下）关系，一个结点只能有一个父结点。根结点可以有父结点
// 坑爹的是可以像这样：
// 例子  1--->2--->3--->4--->1
// 应该打印：
/*
1:  1级: 1  2级:1   3级: 1
2:  1级: 1  2级:1   3级: 1
3:  1级: 1  2级:1   3级: 1
4:  1级: 1  2级:1   3级: 1
*/

// test部分能不能循环打印？
// 数据库当中怎么实现？go当中怎么实现
package hellojava.node;

public class Node {
	int name;
	Node p;
	int c1;
	int c2;
	int c3;

	public Node(int i) {
		this.name = i;
		this.p = null;
		this.c1 = 0;
		this.c2 = 0;
		this.c3 = 0;
	}

	// 绑定
	// 二环：1-2-1 会造成1和2的三级都是1，影响业务
	// 办法：有些地方增加判断语句：this.p!=y
	// 三环：1-2-3-1 造成1和2的第三级是1，影响业务。 办法：this.p.p!=y
	public void bind(Node y) {
		this.c1++;

		// this.p != y：避免二环 1-2-1
		if (this.p != y) {
			this.c2 += y.c1;
		}

		// 避免二环和 this.p.p != y 三环 1-2-3-1
		if (this.p == null || (this.p != null && this.p != y && this.p.p != y)) {
			this.c3 += y.c2;
		}

		// 针对: 已有 1-2 2-3 接着进行 3-2操作
		if (y.p != null) {
			y.p.delete(y);
		}

		// 避免二环1-2-1
		if (this.p != null && this.p != y) {
			this.p.c2 += 1;
			// 避免三环
			if (this.p.p != y) {
				this.p.c3 += y.c1;
			}
			// 避免三环
			if (this.p.p != null &&this.p.p != y) {
				this.p.p.c3 += 1;
			}
		}
		// 将绑定点的parent设置为this.
		y.p = this;
	}

	// 删除
	public void delete(Node y) {
		this.c1--;

		if (this.p != y) {
			this.c2 -= y.c1;
		}

		if (this.p == null || (this.p != null && this.p != y && this.p.p != y)) {
			this.c3 -= y.c2;
		}

		if (this.p != null && this.p != y) {
			this.p.c2 -= 1;
			if (this.p.p != y) {
				this.p.c3 -= y.c1;
			}
			if (this.p.p != null & this.p.p != y) {
				this.p.p.c3 -= 1;
			}
		}
		y.p = null;
	}

	// 打印
	public void print() {
		System.out.printf("%d:  1级: %d  2级:%d   3级: %d\n", this.name, this.c1, this.c2, this.c3);
	}

	// 测试-------------------------------------------------------------

	// 测试两点循环
	public static void hztest2() {
		System.out.println("二环：");
		Node node1 = new Node(1);
		Node node2 = new Node(2);

		node1.bind(node2);
		node2.bind(node1);

		node1.print();
		node2.print();

		System.out.println("------------------");

	}

	// 测试三点循环
	public static void hztest3() {
		System.out.println("三环");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		node1.bind(node2);
		node2.bind(node3);
		node3.bind(node1);

		node1.print();
		node2.print();
		node3.print();
		System.out.println("------------------");
	}

	// 测试三点回头插入循环 1-2 2-3 3-2
	public static void ctest3() {
		System.out.println("回头型3    1-2  2-3  3-2");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		node1.bind(node2);
		node2.bind(node3);
		node3.bind(node2);

		node1.print();
		node2.print();
		node3.print();
		System.out.println("------------------");
	}

	public static void backtest3() {
		System.out.println(" 回头型  1-2   2-1   2-3");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.bind(node2);

		node2.bind(node3);
		node2.bind(node1);
		node1.print();
		node2.print();
		node3.print();
		System.out.println("------------------");
	}

	// 测试四点回头插入循环 1-2 2-3 3-4 4-3
	public static void ctest4() {
		System.out.println("回头型4  1-2  2-3  3-4  4-3");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.bind(node2);
		node2.bind(node3);
		node3.bind(node4);
		node4.bind(node3);

		node1.print();
		node2.print();
		node3.print();
		node4.print();
		System.out.println("------------------");
	}

	// 测试四点循环
	public static void hztest4() {
		System.out.println("四环 ");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.bind(node2);
		node2.bind(node3);
		node3.bind(node4);
		node4.bind(node1);

		node1.print();
		node2.print();
		node3.print();
		node4.print();
		System.out.println("------------------");

	}

	// 大环回头 1-2 2-3 3-4 4-5 5-6 6-7 7-8 8-1 2-8
	public static void backtest8() {
		System.out.println("回头： 1-2 2-3 3-4 4-5  5-6  6-7  7-8  8-1  2-8 ");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.bind(node2);

		node3.bind(node4);
		node4.bind(node6);
		node6.bind(node5);
		node5.bind(node7);
		node7.bind(node1);
		node2.bind(node3);
		node2.bind(node8);
		node1.print();
		node2.print();
		node3.print();
		node4.print();
		node5.print();
		node6.print();
		node7.print();
		node8.print();
		System.out.println("------------------");
	}

	// 标准的测试：二环，三环，回头插入1-2 2-3 3-2,回头插入1-2 2-1 2-3 ，四环
	public static void hztest() {
		hztest2();
		hztest3();
		ctest3();
		backtest3();
		ctest4();
		hztest4();
		backtest8();

	}

	public static void main(String[] args) {
		hztest();

	}

	// 自定义测试
	public static void test1() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		node1.bind(node2);

		node3.bind(node4);
		node4.bind(node6);
		node6.bind(node5);
		node5.bind(node7);
		node7.bind(node1);
		node2.bind(node3);
		node2.bind(node8);
		node1.print();
		node2.print();
		node3.print();
		node4.print();
		node5.print();
		node6.print();
		node7.print();
		node8.print();
		System.out.println("------------------");
	}
}