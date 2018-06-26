package testAndtry;

import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;

public class TestCloneMap implements Cloneable{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws CloneNotSupportedException {
		//结论HashMap是浅拷贝。
		 HashMap<Integer,String[]>map=new HashMap<Integer,String[]>();
		 map.put(1,new String[]{"hao","zhao"});
		 HashMap<Integer,String[]>map2=(HashMap<Integer, String[]>) map.clone();
		 map2.put(2,new String[]{"cc","tv"});
		 String[]s=map2.get(1);
		 s[1]="haha";
		 System.out.println(JSON.toJSONString(map)+"\n"+JSON.toJSONString(map2));
		 
		//结论ArrayList是浅拷贝。
		 ArrayList<String[]> list=new ArrayList<String[]>();
		 list.add(new String[]{"hao","zhao"});
		 ArrayList<String[]> list2=(ArrayList<String[]>) list.clone();
		 list2.add(new String[]{"cc","tv"});
		 String[]slist=list2.get(0); 
		 slist[1]="ahas";
		 System.out.println(JSON.toJSONString(list)+"\n"+JSON.toJSONString(list2));
	}
}	
