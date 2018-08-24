package TestCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTry {
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("test.properties"));
			String name = (String) p.getProperty("name");
			System.out.println(name);
			String name2 = (String) p.getProperty("name2");
			System.out.println(name2);
			
			System.out.println("===========");
			Enumeration<?> emu=p.propertyNames();
			
			while (emu.hasMoreElements()){
				System.out.println(emu.nextElement());
			}
			
			Set<String> set=p.stringPropertyNames();
			
			System.out.println(set);
			
			{
				System.out.println("===========");
				Set<Object> pSet = p.keySet();
				Iterator<Object> i = pSet.iterator();
				while (i.hasNext()) {
					String key = (String) i.next();
					System.out.println(p.getProperty(key));
					if (key.equals("name")) {
						i.remove();// É¾³ý
					}
				}
			}
			System.out.println("===========");

			String name3 = (String) p.getProperty("name");
			System.out.println(name3);// ¾ÓÈ»Ã»ÁË£¡£¡
			
			File fileout=new File("test_bak.properties");
			
			if (!fileout.exists()){
				fileout.createNewFile();
			}
			
			p.list(new PrintStream(fileout));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
