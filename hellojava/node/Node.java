// ����ģ�ͣ���ʾ��ĳ�����1.2.3�Ӽ�������,��ϵ��:���ӣ����£���ϵ��һ�����ֻ����һ������㡣���������и����
// �ӵ����ǿ�����������
// ����  1--->2--->3--->4--->1
// Ӧ�ô�ӡ��
/*
1:  1��: 1  2��:1   3��: 1
2:  1��: 1  2��:1   3��: 1
3:  1��: 1  2��:1   3��: 1
4:  1��: 1  2��:1   3��: 1
*/

// test�����ܲ���ѭ����ӡ��
// ���ݿ⵱����ôʵ�֣�go������ôʵ��
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

	// ��
	// ������1-2-1 �����1��2����������1��Ӱ��ҵ��
	// �취����Щ�ط������ж���䣺this.p!=y
	// ������1-2-3-1 ���1��2�ĵ�������1��Ӱ��ҵ�� �취��this.p.p!=y
	public void bind(Node y) {
		this.c1++;

		// this.p != y��������� 1-2-1
		if (this.p != y) {
			this.c2 += y.c1;
		}

		// ��������� this.p.p != y ���� 1-2-3-1
		if (this.p == null || (this.p != null && this.p != y && this.p.p != y)) {
			this.c3 += y.c2;
		}

		// ���: ���� 1-2 2-3 ���Ž��� 3-2����
		if (y.p != null) {
			y.p.delete(y);
		}

		// �������1-2-1
		if (this.p != null && this.p != y) {
			this.p.c2 += 1;
			// ��������
			if (this.p.p != y) {
				this.p.c3 += y.c1;
			}
			// ��������
			if (this.p.p != null &&this.p.p != y) {
				this.p.p.c3 += 1;
			}
		}
		// ���󶨵��parent����Ϊthis.
		y.p = this;
	}

	// ɾ��
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

	// ��ӡ
	public void print() {
		System.out.printf("%d:  1��: %d  2��:%d   3��: %d\n", this.name, this.c1, this.c2, this.c3);
	}

	// ����-------------------------------------------------------------

	// ��������ѭ��
	public static void hztest2() {
		System.out.println("������");
		Node node1 = new Node(1);
		Node node2 = new Node(2);

		node1.bind(node2);
		node2.bind(node1);

		node1.print();
		node2.print();

		System.out.println("------------------");

	}

	// ��������ѭ��
	public static void hztest3() {
		System.out.println("����");
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

	// ���������ͷ����ѭ�� 1-2 2-3 3-2
	public static void ctest3() {
		System.out.println("��ͷ��3    1-2  2-3  3-2");
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
		System.out.println(" ��ͷ��  1-2   2-1   2-3");
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

	// �����ĵ��ͷ����ѭ�� 1-2 2-3 3-4 4-3
	public static void ctest4() {
		System.out.println("��ͷ��4  1-2  2-3  3-4  4-3");
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

	// �����ĵ�ѭ��
	public static void hztest4() {
		System.out.println("�Ļ� ");
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

	// �󻷻�ͷ 1-2 2-3 3-4 4-5 5-6 6-7 7-8 8-1 2-8
	public static void backtest8() {
		System.out.println("��ͷ�� 1-2 2-3 3-4 4-5  5-6  6-7  7-8  8-1  2-8 ");
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

	// ��׼�Ĳ��ԣ���������������ͷ����1-2 2-3 3-2,��ͷ����1-2 2-1 2-3 ���Ļ�
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

	// �Զ������
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