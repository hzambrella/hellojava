// 反序列化，从e:/jp/tmp/e.ser读取信息
package hellojava.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
	public static void main(String[] args) {
		Employees e = null;
		try {
			// 文件
			FileInputStream fileIn = new FileInputStream("e:/jp/tmp/e.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// 该方法从流中取出下一个对象，并将对象反序列化。它的返回值为Object，因此，你需要将它转换成合适的数据类型。
			e = (Employees) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException i) {
			System.out.println("class not found");
			i.printStackTrace();
			return;
		}
		System.out.println(e.name);
		System.out.println(e.address);
		System.out.println(e.number);
		// 由于transient修饰符，这个打印不出来
		System.out.println(e.SSN);
	}

}
