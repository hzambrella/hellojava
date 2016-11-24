// 分销：显示出某个点的1.2.3子级的数量,关系不是树性，是任意的网性，只有父子（上下）关系。
// 例子  1-->2--->3--->4--->1
// 改进：test部分能不能循环打印？
// 思考：数据库当中怎么实现？go当中怎么实现
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

	public void bind(Node y) {
		this.c1++;
		this.c2 += y.c1;
		this.c3 += y.c2;
		y.p=this;
		if (this.p != null) {
			this.p.c2 += 1;
			this.p.c3 += y.c1;
			if (this.p.p != null) {
				this.p.p.c3 += 1;
			}
		}

	}

	public void print() {	
		System.out.printf("%d:  1阶: %d  2阶:%d   3阶: %d\n", this.name, this.c1, this.c2, this.c3);
	}
// 测试
public static void test1(){
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

public static void test2(){
	Node node1 = new Node(1);
	Node node2 = new Node(2);
	Node node3 = new Node(3);

	node1.bind(node2);
	node2.bind(node3);
	//node3.bind(node1);

	node1.print();
	node2.print();
	node3.print();

}
	public static void main(String[] args) {
	test2();
	//System.out.println("------------------");

	}

}