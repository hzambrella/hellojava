package testAndtry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TestReflect {
	private int number=1;
	protected String str="arf";
	private Date date=new Date();
	ArrayList<Integer> list=new ArrayList<Integer>();
		
	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> cs=Class.forName("testAndtry.TestReflect");
		Field[] fields=cs.getFields();
		System.out.println(Arrays.toString(fields));
		
		Method[] methods=cs.getMethods();
		System.out.println(Arrays.toString(methods));
		
		Constructor<?>[] cons=cs.getConstructors();
		System.out.println(Arrays.toString(cons));
		
		Field[] dfields=cs.getDeclaredFields();
		System.out.println(Arrays.toString(dfields));
		
		Method[] dmethods=cs.getDeclaredMethods();
		System.out.println(Arrays.toString(dmethods));
		
		Constructor<?>[] dcons=cs.getDeclaredConstructors();
		System.out.println(Arrays.toString(dcons));
		for (Field df:dfields){
			System.out.println(Modifier.toString(df.getModifiers())+":"+df.getName());
		}
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Date getDate() {
		return date;
	}
	
	public ArrayList<Integer> getList() {
		return list;
	}
}
