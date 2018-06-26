package TestCollection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args){
		Map<Integer,Object>m=new HashMap<Integer,Object>();
		String s="hello";
		m.put(1, s);
		s="world";
		System.out.println(m.get(1));//²»ÊÇworld
		
		TestBean t=new TestBean();
		m.put(2, t);
		t.haha=200;
		System.out.println(m.get(2));

	}
	
	
}

class TestBean{
	public int haha=1;
	
	public String toString(){
		return Integer.toString(haha);
	}
}