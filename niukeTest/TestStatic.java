package niukeTest;

import java.util.HashMap;
import java.util.Map;

public class TestStatic<T> {
	public static int value=0;
	
	public static void main(String[] args) {
		TestStatic<Integer> t1=new TestStatic<>();
		t1.value=1;
		TestStatic<String> t2=new TestStatic<>();
		t2.value=2;
		
		System.out.println(TestStatic.value);
		
		Map<String,String>map=new HashMap<>();
	}
}
