// ���л�
//1) �Ѷ�����ֽ��������õر��浽Ӳ����(ͨ�������һ���ļ���); 2) �������ϴ��Ͷ�����ֽ�����
package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializable {
	
	public static void main(String []args) {
		Employees employee = new Employees();
		employee.name = "haozhao";
		employee.address = "wukeda";
		employee.number=1656141;
		employee.SSN=111;
		try{
			//�ļ������
			FileOutputStream fileout=new FileOutputStream("E:/jp/tmp/e.ser");
			// ���л�
			ObjectOutputStream out=new ObjectOutputStream(fileout);
			//���л�һ�����󣬲��������͵������
			out.writeObject(employee);
			out.close();
			fileout.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}
