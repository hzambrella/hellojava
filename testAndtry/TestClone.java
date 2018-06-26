package testAndtry;

import java.util.ArrayList;
import java.util.Arrays;


//≤‚ ‘clone

public class TestClone{
//public class TestClone {
	public String[] al=new String[2];
	public static void main(String[] args) {
		TestClone test=new TestClone();
		try {
			TestClone testCopy=test;
			TestClone testClone= (TestClone) test.clone();
			testCopy.al[0]="123";
			
			System.out.println(Arrays.toString(test.al)
					+"--"+Arrays.toString(testCopy.al)+"--"+Arrays.toString(testClone.al));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public TestClone clone() throws CloneNotSupportedException {
		TestClone tc=(TestClone)super.clone();	
		tc.al=al.clone();
		return tc;
	}

}
