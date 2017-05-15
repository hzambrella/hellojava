package mashibin.consumer;

// 线程章节，消费者问题
// 生产，消费。
//知识点:wait(),notify()。锁。sleep和wait的区别。
//sleep不会让出对象的锁。wait会。

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
		System.out.println("主线程结束");
	}
}


class Dongxi{
	public int id;
	public static Integer sum=0;//生产总量
	
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
		//问题1：怎么创建一个对象数组？
		Dongxi dx[]=new Dongxi[20];
		this.cap=20;
		this.dxStack=dx;
	}	
	
	public Store(int cap){
		//问题1：怎么创建一个对象数组？
		Dongxi dx[]=new Dongxi[cap];
		this.cap=cap;
		this.dxStack=dx;
	}		
	
	public synchronized void push(String name){
		Dongxi dx=new Dongxi();
		//问题2：数组越界。
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
		System.out.println(name+"生产了东西，id:"
		+dx.id+"(当前已生产总量为："+Dongxi.sum+"。剩余库存:"+flag+")");
	}
	
	public synchronized void pop(String name){
		
		try{
			Thread.sleep(100);//时延。
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
		System.out.println(name+"消费了东西，id:"
				+did
				+"。剩余库存:"+flag+")");
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
			if (Dongxi.sum>50){//总共生产50个
				flag=false;
				System.out.println("生产停止！");
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
			if (Dongxi.sum>50){//总共消费50个
				flag=false;
				System.out.println("消费停止！");
			}
		}
	}
}
	