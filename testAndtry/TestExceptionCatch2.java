package testAndtry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestExceptionCatch2 {
	//ֻ�ᵽ��һ�������catch
	public static void main(String[] args) throws Throwable {
		try{
			FileReader fread=new FileReader(new File("asfdasdfasf.txtt"));
		}catch(FileNotFoundException e){
			Throwable newE=new TestSelfException();
			newE.initCause(e);
			throw newE;
//			throw e;
		}
	}
}
