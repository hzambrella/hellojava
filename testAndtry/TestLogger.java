package testAndtry;

import java.util.logging.Logger;

public class TestLogger {
	public static void main(String[] args) {
		try{
			throw new Exception();
		}catch(Exception e){
			Logger.getGlobal().info("123131");
		}
		
	}
}
