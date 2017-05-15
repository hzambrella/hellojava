package ThreadDeadLock;


//��ThreadLock
//synchronized���壬 static������



//��ϰ3������
public class ThreadDeadLock  extends Thread{
	int flag=0;
	//����1��û����������!
	//Object o1=new Object();
	//Object o2=new Object();
	
	//������������static
	//��Ϊstatic�Ż������Դ����
	//����static �ı������еĵ��ö���ͬһ���ڴ棨ͬһ�����̣���
	//���������߳�����Ҫ�ı�����һ���ģ�
	//��ô����������ѧ�������ٽ���Դ��һ��ֻ�ܸ�һ�����̷���
	//�����������һ�����ϵ��ٽ���Դ��
	//https://zhidao.baidu.com/question/436102483.html

	static Object o1=new Object();
	static Object o2=new Object();
	

	public void run(){
		if (this.flag==1){
			System.out.println("flag:"+this.flag);
			synchronized(o1){
				try {
					Thread.sleep(100);
				}catch (Exception e){
					e.printStackTrace();
				}
				System.out.println("o1");
				
				synchronized(o2){
					System.out.println("o2");
				}
			}
		}//flag==1
		
			if (this.flag==0){
				System.out.println("flag:"+this.flag);
				synchronized(o2){
					try {
						Thread.sleep(2000);
					}catch (Exception e){
						e.printStackTrace();
					}
					System.out.println("o2");
					
					synchronized(o1){
						System.out.println("o1");
					}
				}
			
			
		}//flag==0
	}//run()
	
	public static void main(String[] args){
		ThreadDeadLock t1=new ThreadDeadLock();
		ThreadDeadLock t2=new ThreadDeadLock();
		t1.flag =0;
		t1.flag =1;
		t1.start();
		t2.start();
	}
}//class ThreadDeadLock


