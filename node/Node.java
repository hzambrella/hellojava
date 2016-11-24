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
package node;

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
	public void bind(Node y) {
		this.c1++;
		System.out.println(this.name + ": this.c1:" + this.c1);
		if (this.p != y) {
			this.c2 += y.c1;
		}
		System.out.println(this.name + ": this.c2:" + this.c2);

		if (this.p == null || (this.p != null && this.p != y && this.p.p != y)) {
			this.c3 += y.c2;
		}
		System.out.println(this.name + ": this.c3:" + this.c3);

		if (y.p != null) {
			y.p.delete(y);
		}

		if (this.p != null && this.p != y) {
			this.p.c2 += 1;
			if (this.p.p!=y){
			this.p.c3 += y.c1;
			}
			if (this.p.p != null&this.p.p!=y) {
				this.p.p.c3 += 1;
			}
		}
		y.p = this;
	}

	// 删除
	public void delete(Node y) {
		this.c1--;
		this.c2 -= y.c1;
		this.c3 -= y.c2;
		y.p = this;
		if (this.p != null) {
			this.p.c2 -= 1;
			this.p.c3 -= y.c1;
			if (this.p.p != null) {
				this.p.p.c3 -= 1;
			}
		}
	}

	// 打印
	public void print() {
		System.out.printf("%d:  1级: %d  2级:%d   3级: %d\n", this.name, this.c1, this.c2, this.c3);
	}

	// 测试-------------------------------------------------------------
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
	}

	// 测试两点循环
	public static void hztest2() {
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

	// 测试四点循环
	public static void hztest4() {
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

	public static void main(String[] args) {
		hztest4();

		// test3();
	}

}