package swap;

// ָ�봫�ݣ�ʧ�ܣ�
public class ByReference {
	public int x;
	public int y;

	public ByReference(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void swap(ByReference my) {
		System.out.println("����������������ô���");
		my.x = my.x ^ my.y;
		my.y = my.y ^ my.x;
		my.x = my.x ^ my.y;
	}
}
