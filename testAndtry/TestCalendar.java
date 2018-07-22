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
        /*��ȡ���������*/  
        System.out.println("����������ǣ�"+calendar.get(Calendar.DAY_OF_MONTH));  
        /*��ȡʮ��֮�������*/  
        calendar.clear();//����̳е�ǰϵͳ��ʱ��  
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+10);  
        System.out.println("ʮ��֮��������ǣ�"+calendar.get(Calendar.DAY_OF_MONTH));  
        
        System.out.println("2000��2���ж����죺"+MaxDayOfMonth(2000,2));
        now();
        testSetAndAdd();
	}
	
	public static void now(){
		System.out.println("=======now=======");
		 Calendar calendar=Calendar.getInstance();  //���ڵ�ʱ��
		 System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//һ���ڵĵڼ���(�����ǵ�һ��)
		 System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//һ���µĵڼ���
		 System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));//����µĵڼ���
		 System.out.println(calendar.get(Calendar.AM));
		 System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//Сʱ
		 System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));//����ĵڼ���
		 System.out.println(calendar.get(Calendar.DATE));
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 System.out.println(format.format(calendar.getTime()));//����Date����
	}
	
	public static void testSetAndAdd(){
		System.out.println("=======testSetAndAdd=======");
		Calendar calendar=Calendar.getInstance();  //���ڵ�ʱ��
		calendar.clear();
		calendar.set(2008, 8, 2);//1����0��
		System.out.println(format.format(calendar.getTime()));
		calendar.add(Calendar.DATE, -5);
		System.out.println(format.format(calendar.getTime()));
		calendar.roll(Calendar.DATE, 5);
		System.out.println(format.format(calendar.getTime()));
	}
	
	/**
	 * ����ĳ�����������
	 */
	public static int MaxDayOfMonth(int year,int month){
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.set(Calendar.MONTH,month-1);//Ĭ��1��Ϊ0��  
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
        return day;
	}
}
