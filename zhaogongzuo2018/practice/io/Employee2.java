package zhaogongzuo2018.practice.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee2 implements Externalizable{
	private String name;
	private Date join;
	private Integer salary;
	
	//要有无参构造方法
	public Employee2(){
	}
	
	public Employee2(String name,Date join,Integer salary){
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(salary);
		out.writeObject(join);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name=in.readUTF();
		this.salary=in.readInt();
		this.join=(Date) in.readObject();
	}
}
