package zhaogongzuo2018.practice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndCalendar {
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(sf.format(date));
	}
}
