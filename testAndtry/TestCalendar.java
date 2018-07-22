package testAndtry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	private static Calendar calendar=new GregorianCalendar();
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		
        calendar.setTime(new Date());  
        /*获取今天的日期*/  
        System.out.println("今天的日期是："+calendar.get(Calendar.DAY_OF_MONTH));  
        /*获取十天之后的日期*/  
        calendar.clear();//避免继承当前系统的时间  
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+10);  
        System.out.println("十天之后的日期是："+calendar.get(Calendar.DAY_OF_MONTH));  
        
        System.out.println("2000年2月有多少天："+MaxDayOfMonth(2000,2));
        now();
        testSetAndAdd();
	}
	
	public static void now(){
		System.out.println("=======now=======");
		 Calendar calendar=Calendar.getInstance();  //现在的时间
		 System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//一星期的第几天(周日是第一天)
		 System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//一个月的第几天
		 System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));//这个月的第几周
		 System.out.println(calendar.get(Calendar.AM));
		 System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//小时
		 System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));//今年的第几周
		 System.out.println(calendar.get(Calendar.DATE));
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 System.out.println(format.format(calendar.getTime()));//返回Date类型
	}
	
	public static void testSetAndAdd(){
		System.out.println("=======testSetAndAdd=======");
		Calendar calendar=Calendar.getInstance();  //现在的时间
		calendar.clear();
		calendar.set(2008, 8, 2);//1月是0月
		System.out.println(format.format(calendar.getTime()));
		calendar.add(Calendar.DATE, -5);
		System.out.println(format.format(calendar.getTime()));
		calendar.roll(Calendar.DATE, 5);
		System.out.println(format.format(calendar.getTime()));
	}
	
	/**
	 * 计算某个月最大天数
	 */
	public static int MaxDayOfMonth(int year,int month){
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.set(Calendar.MONTH,month-1);//默认1月为0月  
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
        return day;
	}
}
