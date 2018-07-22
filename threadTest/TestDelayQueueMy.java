package threadTest;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayQueueMy  {
	public static void main(String[] args) {
		TestDelayQueueMy test=new TestDelayQueueMy();
		Manager manager=test.new Manager();
		Task t1=test.new Task("task1",3000,TimeUnit.MILLISECONDS);
		Task t2=test.new Task("task2",1000,TimeUnit.MILLISECONDS);
		Task t3=test.new Task("task3",2000,TimeUnit.MILLISECONDS);
		manager.addTask(t1);
		manager.addTask(t2);
		manager.addTask(t3);
		
		Thread tm=new Thread(manager);
		tm.start();
	}
	
	public class Manager implements Runnable{
		private DelayQueue<Task> dq=new DelayQueue<Task>();
		public void addTask(Task task){
			dq.add(task);
			System.out.println(task.getName()+":��ӳɹ�");
		}
		
		@Override
		public void run(){
			while(!dq.isEmpty()){
				Task task;
				try {
					task = dq.take();
					System.out.println(task.getName()+" ���");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
		}
	}
	
	public class Task implements Delayed{
		private long delayTime;//��Ҫ���ѵ�ʱ�䣬��λ���롣
		private String name;
		private long executeTime;
		public Task(String name,long delayTime, TimeUnit delayTimeUnit){
			this.name=name;
			this.delayTime=delayTime;
			//����ʱ��=���ڵ�ʱ��+�ӳ�ʱ��
			this.executeTime=System.currentTimeMillis()+delayTimeUnit.toMillis(delayTime);
		}
		
		public String getName() {
			return name;
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.getDelay(TimeUnit.MILLISECONDS)==o.getDelay(TimeUnit.MILLISECONDS)){
				return 0;
			}
			// ע�⣡-1��1
			return this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS)>0?1:-1;
		}

		@Override
		public long getDelay(TimeUnit unit) {
//			return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
			return executeTime - System.currentTimeMillis();
		}
		
	}
}
