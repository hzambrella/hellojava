package swap;

// 指针传递（失败）
public class ByReference {
	public int x;
	public int y;

	public ByReference(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void swap(ByReference my) {
		System.out.println("尝试其它类进行引用传递");
		my.x = my.x ^ my.y;
		my.y = my.y ^ my.x;
		my.x = my.x ^ my.y;
	}
}
