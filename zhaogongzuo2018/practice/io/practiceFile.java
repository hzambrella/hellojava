package zhaogongzuo2018.practice.io;

import java.io.*;
import java.util.Arrays;

public class practiceFile {
	public static void main(String[] args) throws IOException {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		File f=new File("test/testFile.txt");
		System.out.println(f.exists());
//		File tempf=File.createTempFile("test", "txt");
//		System.out.println(tempf.getAbsolutePath());
//		FileOutputStream inf=new FileOutputStream(tempf);
//		inf.write(new String("asdfas霍夫卡上的花费卡号").getBytes());
//		inf.flush();
//		inf.close();
//		tempf.delete();
		System.out.println(f.getPath());
		System.out.println(f.getParent());
		System.out.println(f.isAbsolute());
		System.out.println(f.length());
		System.out.println(f.getParentFile().getAbsolutePath());
		
		testList();
//		testOperate();
	
	}
	
	static void testList(){
		File f=new File("f://HTMLhz/studyhtml");
		System.out.println(f.exists());
		System.out.println(Arrays.toString(f.list()));
		
	}
	
	static void testOperate(){
		File dir=new File("test/test2/"+String.valueOf(System.currentTimeMillis()));
		dir.mkdirs();
		dir.renameTo(new File("test/test3"));
	}
}
