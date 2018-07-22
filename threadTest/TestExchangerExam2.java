package threadTest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExchangerExam2 {
	public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        final Exchanger<String> exchanger = new Exchanger<String>();
        executor.execute(new Runnable() {
            String data1 = "������ɭ��С������˹";
            
 
            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });
        
 
        executor.execute(new Runnable() {
            String data1 = "�����";
 
            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });
        
        executor.execute(new Runnable() {
            String data1 = "����˹";
 
            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });
        
        executor.execute(new Runnable() {
            String data1 = "����������˹������";
 
            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });
        
        executor.shutdown();
    }
 
    private static void nbaTrade(String data1, Exchanger<String> exchanger) {
        try {
            System.out.println(Thread.currentThread().getName() + "�ڽ��׽�ֹ֮ǰ�� " + data1 + " ���׳�ȥ");
            Thread.sleep((long) (Math.random() * 1000));
 
            String data2 = (String) exchanger.exchange(data1);
            System.out.println(Thread.currentThread().getName() + "���׵õ�" + data2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
