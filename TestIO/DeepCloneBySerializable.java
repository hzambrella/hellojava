package TestIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeepCloneBySerializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		CloneTarget ct=new CloneTarget();
		ct.getList().add("dasasdfa");
		ct.getList().add("cadsfa");
		

		CloneTarget ct2=deepCloneCloneTarget(ct);
		ct2.getList().add("ecdfasf");
		
		System.out.println(ct);
		System.out.println(ct2);
	}
	
	public static CloneTarget deepCloneCloneTarget(CloneTarget ct) throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bout);
		out.writeObject(ct);
		
		ByteArrayInputStream bin=new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream in=new ObjectInputStream(bin);
		CloneTarget ct2=(CloneTarget) in.readObject();
		return ct2;
	}
}
