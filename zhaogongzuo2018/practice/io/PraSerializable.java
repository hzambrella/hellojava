package zhaogongzuo2018.practice.io;


import java.io.*;
import java.util.Date;

public class PraSerializable {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		testPra1();
		testPra2();
		

	        int result=0;
	        for (int i=1;i<=13;i++){
	            String str=String.valueOf(i);
	            if (str.indexOf("1")>=0){
	                result++;
	                System.out.println(i);
	            }
	        }
	        System.out.println(result);
	    
		
	}
	
	static void testPra1() throws FileNotFoundException, IOException, ClassNotFoundException{
		Employee em=new Employee("hao",new Date(),1000);
		File employeeTxt=new File("employee.txt");
		if (!employeeTxt.exists()){
			employeeTxt.createNewFile();
		}
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(employeeTxt));
		out.writeObject(em);
		out.close();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(employeeTxt));
		Employee em2=(Employee)in.readObject();
		System.out.println(em2);
		in.close();
	}
	
	static void testPra2() throws IOException, ClassNotFoundException{
		Employee2 em=new Employee2("hao",new Date(),1000);
		File employeeTxt=new File("employee.txt");
		if (!employeeTxt.exists()){
			employeeTxt.createNewFile();
		}
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(employeeTxt));
		out.writeObject(em);
		out.close();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(employeeTxt));
		Employee2 em2=(Employee2)in.readObject();
		System.out.println(em2);
		in.close();
	}
}
