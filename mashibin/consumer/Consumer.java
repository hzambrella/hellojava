package mashibin.consumer;

// �߳��½ڣ�����������
// ���������ѡ�
//֪ʶ��:wait(),notify()������sleep��wait������
//sleep�����ó����������wait�ᡣ

public class Consumer {
	public static void main(String[] args){
		Store store=new Store();
		Producer p1=new Producer(store,"p1");
		Producer p2=new Producer(store,"p2");
		Producer p3=new Producer(store,"p3");
		User u1=new User(store,"u1");
		User u2=new User(store,"u2");
		(new Thread(p1)).start();
		(new Thread(p2)).start();
		(new Thread(p3)).start();
		(new Thread(u1)).start();
		(new Thread(u2)).start();
		System.out.println("���߳̽���");
	}
}


class Dongxi{
	public int id;
	public static Integer sum=0;//��������
	
	public Dongxi(){
		this.id=sum;
		sum++;
	}
	
	public String toString(){
		return String.valueOf(this.id);
	}
}

class Store {
	public Dongxi[] dxStack;
	public final int cap;
	public int flag=0;
	
	public Store(){
		//����1����ô����һ���������飿
		Dongxi dx[]=new Dongxi[20];
		this.cap=20;
		this.dxStack=dx;
	}	
	
	public Store(int cap){
		//����1����ô����һ���������飿
		Dongxi dx[]=new Dongxi[cap];
		this.cap=cap;
		this.dxStack=dx;
	}		
	
	public synchronized void push(String name){
		Dongxi dx=new Dongxi();
		//����2������Խ�硣
		while(this.flag>=(this.cap-1)){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		
		try{
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		this.dxStack[this.flag]=dx;
		this.flag++;
		System.out.println(name+"�����˶�����id:"
		+dx.id+"(��ǰ����������Ϊ��"+Dongxi.sum+"��ʣ����:"+flag+")");
	}
	
	public synchronized void pop(String name){
		
		try{
			Thread.sleep(100);//ʱ�ӡ�
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		while((this.flag-1)<0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		int did=this.dxStack[this.flag-1].id;
		//System.out.println("pop"+this.store.flag);
		this.dxStack[this.flag-1]=null;
		this.flag--;
		System.out.println(name+"�����˶�����id:"
				+did
				+"��ʣ����:"+flag+")");
	}
	
	
	
}

class Producer implements Runnable{
	Store store;
	public String name;
	private boolean flag=false;
	
	public Producer(Store s,String name){
		this.store=s;
		this.name=name;
	}
		
	public void run(){
		flag=true;
		
		while(flag){
			
			store.push(this.name);
			if (Dongxi.sum>50){//�ܹ�����50��
				flag=false;
				System.out.println("����ֹͣ��");
			}
		}
	}
}

class User implements Runnable{
	Store store;
	public String name;
	private boolean flag=false;
	
	public User(Store s,String name){
		this.store=s;
		this.name=name;
	}
	

	public void run(){
		flag=true;
		while(flag){
			store.pop(this.name);
			if (Dongxi.sum>50){//�ܹ�����50��
				flag=false;
				System.out.println("����ֹͣ��");
			}
		}
	}
}
	