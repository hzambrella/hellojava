package threadTest;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	final int[] account=new int[]{20,50};//�����˵�Ǯ
	private ReentrantLock lock =new ReentrantLock();//��
	private Condition sufficientFund=lock.newCondition();//��������

	public void transfer(int from,int to,int amount) throws InterruptedException{
		lock.lock();
		System.out.println(from+"-->"+to);
		try{
			//Ǯ����ʱ����
			while(account[from]<amount){
				sufficientFund.await();//�ó���������������ȴ���
				System.out.printf("ת��ʧ�� �û�%d ����\n",from);
			}
			account[from]-=amount;
			account[to]+=amount;
			System.out.printf("�û�%d ת%dԪ���û�%d\n",from,amount,to);
			Thread.sleep(500);
			System.out.println("ת�˳ɹ�"+Arrays.toString(account));
			sufficientFund.signalAll();//֪ͨ�ȴ��ص����������߳�����
		}finally{
			lock.unlock();
		}
	}
}
