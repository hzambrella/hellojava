package mashibin.ThreadDeadLock;

//synchronizedȦ��Ĵ���飬ֻ����һ���̷߳��ʡ�
//�ù�����,�����߳���Ȼ���Է��ʷ�synchronizedȦ��Ĵ���顣
class TT extends Thread{
	int b=100;
	String name;
	
	public TT(String name){
		this.name=name;
	}
	
	public synchronized void m1()throws Exception{
		b=1000;
		Thread.sleep(3000);//ִ��3��
		System.out.println("m1() b="+this.name+" "+b);
	}
	
	
	// �޸��������synchronized��ȥ��������
	
	public  void  m2()throws Exception{ //m2 1000 m1 1000 ��������ʱ���һЩ
	//public synchronized  void  m2()throws Exception{// m2 200 m1 1000
													//��������ʱ�䳤һЩ
		b=200;
		Thread.sleep(2000);
		System.out.println("m2() b="+this.name+" "+b);
	}
	
	public void run(){
		try{
			this.m1();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class ThreadSync {
	public static void main(String[] args)throws Exception{
		TT tt=new TT("t1");
		//TT t2=new TT("t2");
		tt.start();
		//System.out.println("3s.....");
		//tt.m1();
		//tt.m2();
		//System.out.println("3s.....");
		//t2.m1();
		//System.out.println("after 1s");
		//Thread.sleep(1000);//ִ�����߳�1�룬ȷ�����ڷ��߳�����
						   //�����з��ʵķ�synchronized�����
		tt.m2();//���1000
		
		
	}
}

