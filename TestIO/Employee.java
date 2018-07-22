package TestIO;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int salary;
	private transient Date date;
	private static String testStatic="testStatic";
	
	
	public Employee(String name,int salary,int year,int month,int day){
		this.name=name;
		this.salary=salary;
		Calendar calendar=Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);
		this.date=calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		if (date!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return String.format("%s:%d|", name,salary)+sdf.format(date);
		}else{
			return String.format("%s:%d|", name,salary);
		}
	}

}
