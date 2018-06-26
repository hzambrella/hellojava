package designPattern;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Single {
	
	public static void  main(String[] args) {	        
		Integer i1=128;
		Integer i2=128;
		System.out.println(i1==i2);
		System.out.println(i1 instanceof Object);
		try {
			testHungrySingle();
			testStaticClassSingle();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	
	
	public static void testHungrySingle()throws InterruptedException{
		HungrySingle hs=HungrySingle.getInstance();
		hs.pr();
		Thread.sleep(4000);
		HungrySingle hs2=HungrySingle.getInstance();
		hs2.pr();
		Thread.sleep(4000);
		HungrySingle hs3=HungrySingle.getInstance();
		hs3.pr();
		Thread.sleep(4000);
		HungrySingle hs4=HungrySingle.getInstance();
		hs4.pr();
	}
	
	public static void testStaticClassSingle()throws InterruptedException{
		StaticClassSingle hs=StaticClassSingle.getInstance();
		hs.pr();
		Thread.sleep(4000);
		StaticClassSingle hs2=StaticClassSingle.getInstance();
		hs2.pr();
		Thread.sleep(4000);
		StaticClassSingle hs3=StaticClassSingle.getInstance();
		hs3.pr();
		Thread.sleep(4000);
		StaticClassSingle hs4=StaticClassSingle.getInstance();
		hs4.pr();
	}
}

class HungrySingle{
	private String time;
	private final static HungrySingle instance=new HungrySingle();
	
	private HungrySingle(){
		 Date now = new Date( );
	     SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	     time=ft.format(now);
	}
	
	public static HungrySingle getInstance(){
		return instance;
	}
	
	public void pr(){
		System.out.println(time);
	}
}

class LazySingle{
	//TODO
}


class StaticClassSingle{
	private String time;
	
	private static class SingleHolder{
		private static final StaticClassSingle instance=new StaticClassSingle();
	}
	
	private StaticClassSingle(){
		 Date now = new Date( );
	     SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	     this.time=ft.format(now);
	};
	
	public static StaticClassSingle getInstance(){
		return SingleHolder.instance;
	}
	
	public void pr(){
		System.out.println(time);
	}
}




