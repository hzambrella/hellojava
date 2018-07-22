package TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestExternalizable{
	public static void main(String[] args) throws FileNotFoundException, IOException {
		HaveOwnWayToSerialize em=new HaveOwnWayToSerialize("a",1.0,2.0);
		File target= new File("HaveOwnWayToSerialize.dat");
		if (!target.exists()){
			target.createNewFile();
		}
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(target));
		out.writeObject(em);
		
		out.close();
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(target));
		try {
			HaveOwnWayToSerialize em2 = (HaveOwnWayToSerialize) in.readObject();
			System.out.println(em2);
			in.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
