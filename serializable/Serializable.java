// 序列化
//1) 把对象的字节序列永久地保存到硬盘上(通常存放在一个文件中); 2) 在网络上传送对象的字节序列
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
			//文件输出流
			FileOutputStream fileout=new FileOutputStream("E:/jp/tmp/e.ser");
			// 序列化
			ObjectOutputStream out=new ObjectOutputStream(fileout);
			//序列化一个对象，并将它发送到输出流
			out.writeObject(employee);
			out.close();
			fileout.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}
