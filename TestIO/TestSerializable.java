package TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable {
	public static void main(String[] args) throws IOException {
		File target= new File("employSerial.dat");
		if (!target.exists()){
			target.createNewFile();
		}
		
		
		Employee em=new Employee("haozho", 1000, 1990, 3, 23);
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(target));
		out.writeObject(em);
		
		out.close();
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(target));
		Employee em2;
		try {
			em2 = (Employee) in.readObject();
			System.out.println(em2);
			in.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
