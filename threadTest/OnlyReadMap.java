package threadTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OnlyReadMap {
	public HashMap<String,String>testMap;
	
	public OnlyReadMap(){
		testMap=new HashMap<String,String>();
		testMap.put("1","2");
	}
	
	public static void main(String[] args){
		OnlyReadMap orp=new OnlyReadMap();
		Map<String,String>readMap=Collections.unmodifiableMap(orp.testMap);
		Map<String,String> map2=new HashMap<String,String>(orp.testMap);
		Map<String,String>readMap2=Collections.unmodifiableMap(map2);
		printMap(readMap);
		printMap(readMap2);
		orp.testMap.put("2", "3");
		printMap(readMap);
		printMap(readMap2);
		System.out.println(readMap==orp.testMap);
/*		readMap.put("4", "5");*///抛出不支持修改的异常
	}
	
	
	public static void printMap(Map<String,String> map){
		Iterator<Entry<String, String>> i=map.entrySet().iterator();
		while(i.hasNext()){
			 Map.Entry<String, String> entry = i.next();
			 System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		System.out.println("--====--------");
	}

}
