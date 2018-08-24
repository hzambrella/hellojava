package threadTest;

public class Format {

	 /**

	  * �������и���

	  */

	 private int readCount = 0;

	 /**

	  * д�����и���

	  */

	 private int writeCount = 0;

	 /**

	  * ��ȡ����,������д�������ڵ�ʱ����ܻ�ȡ

	  */

	 public synchronized void lockRead() throws InterruptedException {

	   // д������,��Ҫwait

	   while (writeCount > 0) {

	     wait();

	   }

	   readCount++;

	 }

	 /**

	  * �ͷŶ���

	  */

	 public synchronized void unlockRead() {

	   readCount--;

	   notifyAll();

	 }

	 /**

	  * ��ȡд��,����������ʱ��Ҫwait.

	  */

	 public synchronized void lockWrite() throws InterruptedException {

	   // ���ж��Ƿ���д����
	 
	   while (writeCount > 0) {

	     wait();

	   }

	   // ��ʱ�Ѿ������ڻ�ȡд�����߳���,���ռ��,��ֹд������

	   writeCount++;

	   // ����Ϊ0ʱ��ȡд��

	   while (readCount > 0) {

	     wait();

	   }

	 }

	 /**

	  * �ͷŶ���

	  */

	 public synchronized void unlockWrite() {

	   writeCount--;

	   notifyAll();

	 }

	}
