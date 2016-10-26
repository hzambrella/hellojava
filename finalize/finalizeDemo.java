package finalize;
// ���磬�����ʹ��finalize()��ȷ��һ������򿪵��ļ����ر��ˡ�
public class finalizeDemo {
	public static void main(String[] args) {
		Cake c1 = new Cake(1);
		Cake c2 = new Cake(2);
		Cake c3 = new Cake(3);

		c2 = c3 = null;
		System.gc(); // ����Java�����ռ���
	}
}

class Cake extends Object {
	private int id;

	public Cake(int id) {
		this.id = id;
		System.out.println("Cake Object " + id + "is created");
	}

	protected void finalize() throws java.lang.Throwable {
		// finalize();
		//Cake Object 1is created 
		//Cake Object 2is created 
		//Cake Object 3is created
		 
		super.finalize();
		// Cake Object 1is created 
		//Cake Object 2is created 
		//Cake Object 3is created 
		//Cake Object 3is disposed 
		//Cake Object 2is disposed
		
		System.out.println("Cake Object " + id + "is disposed");
	}
}
