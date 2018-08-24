package zhaogongzuo2018.practice.io;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable{
	private String name;
	private Date join;
	private Integer salary;
	
	public Employee(String name,Date join,Integer salary){
		this.name=name;
		this.join=join;
		this.salary=salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoin() {
		return join;
	}
	public void setJoin(Date join) {
		this.join = join;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public String toString(){
		SimpleDateFormat sm=new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		String date=sm.format(join);
		return name+":"+String.valueOf(salary)+"-"+date;
	}
}
