package TestJavaLang;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Properties;

public class TestSystem {
	public static void main(String[] args) {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(time.format(System.currentTimeMillis()));
		System.out.println(time.format(new java.util.Date()));
		System.out.println(System.lineSeparator());
//		testProperties();
	}
	
	public static void testProperties(){
		Properties properties=System.getProperties();
		Iterator iterator=properties.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String) iterator.next();
			System.out.println(key+":"+properties.getProperty(key));
		}
	}
}
