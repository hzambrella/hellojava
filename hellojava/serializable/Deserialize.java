// �����л�����e:/jp/tmp/e.ser��ȡ��Ϣ
package hellojava.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
	public static void main(String[] args) {
		Employees e = null;
		try {
			// �ļ�
			FileInputStream fileIn = new FileInputStream("e:/jp/tmp/e.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// �÷���������ȡ����һ�����󣬲����������л������ķ���ֵΪObject����ˣ�����Ҫ����ת���ɺ��ʵ��������͡�
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
		// ����transient���η��������ӡ������
		System.out.println(e.SSN);
	}

}
