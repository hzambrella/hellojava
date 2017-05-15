package mashibin.ThreadLock;

//ѧϰ�̣߳�1 �̵߳Ľ������߳�������
//�����̵߳����ְ취:�ӿ�Runnable���̳�Thread��
//�����߳�:Thread()
//�ر��߳�(�������ѭ���Ļ���������flag)
//��μ�һ�߳�����������synchronized()
//дһ����������


//��ϰ2Timer.add()�������Ľ��



//public class ThreadDeadLock {//practice 1
public class ThreadLock implements Runnable{//practice2:����Ҳ����Runnable
	Timer ti=new Timer();

	
	
	// practice 2
	public void run(){
		for(;;){
			ti.add(Thread.currentThread().getName());
			//Thread.currentThread().yield();
		}
	}
	

	public static void main(String[] args){
		//��ϰ1�������̣߳������̣߳��ر��߳�
		practice1();
		//��ϰ2������
		//practice2();
	}	//main
	
	
	
	static void practice1(){
		Runner d=new Runner("thread1");
		Runner d2=new Runner("thread2");
		// ����2:��ô�����̣߳�
		Thread t1=new Thread(d);//����Ǽ̳еĻ�����practice2
		Thread t2=new Thread(d);
		Thread t3=new Thread(d2);
		t1.start();
		t2.start();
		t3.start();
		/*��Ӧ��д�����д��runnable��
		try{
			Thread.currentThread().sleep(900);//���⣺���Thread��ô��⣿��Ӧ����CPU�еĽ��̡�
		}catch(InterruptedException i){
			i.printStackTrace();
		}
		 */	
		boolean flag1=false;
		boolean flag2=false;
		for(;;){
			if(d.getI()>10){
				//���󣺴���10ʱ��������ֹͣ
				System.out.println("d.getI():"+d.getI());
				d.shutdown();
				flag1=true;
			}
			
			
			if(d2.getI()>10){
				System.out.println("d2.getI():"+d2.getI());
				d2.shutdown();
				flag2=true;
			}
			
			if (flag1&&flag2){
			//if (flag1){
				System.out.println("main break");
				break;
			}
		}
		
		System.out.println("t1.isAlive()?:"+t1.isAlive());
		System.out.println("t3.isAlive()?:"+t3.isAlive());
	}//practice1

	////��ϰ2������
	public static void practice2(){
		ThreadLock td=new ThreadLock();
		Thread t1=new Thread(td);
		Thread t2=new Thread(td);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
		
	}//practice2:����
	
	public static void practice3(){
	}//practice3//����
}//ThreadDeadLock



// ����1:��ô����һ���߳�
class Runner implements Runnable{
	String name;
	//����3��������ӣ���ô�º͵عر�һ���߳�
	private Boolean flag;
	private int i=1;
	
	public Runner(String name){
		this.name=name;
		this.flag=true;
	}

	public int getI(){
		return this.i;
	}
	
	public void shutdown(){
		this.flag=false;
	}
	
	public void run(){
		
		
		while(this.flag){
			i=i+1;
			
			/*
			try{
				Thread.sleep(100);//���⣺���Thread��ô��⣿��Ӧ����CPU�еĽ��̡�
			}catch(InterruptedException i){
				i.printStackTrace();
			}
			*/
			/*
			if(this.i>10){
				this.flag=false;
			}
			*/
			System.out.println("this is thread"+this.name+":"+i+this.flag);
		}
	}
}//class Runner


//---------------��ϰ2---------
//����1:��ô����
class Timer {
	private int number=0;
	
	public void add(String name){
		synchronized(this){//����1
				this.number++;
				System.out.println(name+":"+this.number);
				try {
					Thread.sleep(900);//����3�����Thread��ô��⣿
				}catch(InterruptedException i){
					//����2����δ�������쳣��
					i.getStackTrace();
				}
		}//synchronized
	}
}//class Timer


/*
 //sysnchornize
Java���ԵĹؼ��֣�������������һ����������һ��������ʱ���ܹ���֤��ͬһʱ�����ֻ��һ���߳�ִ�иöδ��롣

һ�������������̷߳���ͬһ������object�е����synchronized(this)ͬ�������ʱ��һ��ʱ����ֻ����һ���̵߳õ�ִ�С���һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣

����Ȼ������һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ����һ���߳���Ȼ���Է��ʸ�object�еķ�synchronized(this)ͬ������顣

��������ؼ����ǣ���һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ�������̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������

�ġ�����������ͬ����������ͬ������顣Ҳ����˵����һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ�����ͻ�������object�Ķ�����������������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������

�塢���Ϲ��������������ͬ������.
*/