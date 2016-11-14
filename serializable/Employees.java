package serializable;

public class Employees implements java.io.Serializable{
public String name;
public String address;
public int number;
public transient int SSN;
public void mailCheck(){
	System.out.println(name+address);
}
}
