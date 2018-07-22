package TestIO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneTarget implements Serializable{
	private String name;
	private List<String> list;
	
	public CloneTarget(){
		this.list=new ArrayList<>();
		this.name=new SimpleDateFormat().format(System.currentTimeMillis());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	public String toString(){
		return name+Arrays.toString(list.toArray());
	}
}
