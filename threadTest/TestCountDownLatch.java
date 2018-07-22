package threadTest;
 
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
 
public class TestCountDownLatch {
	final static int StudentNum = 20;// �߳���
	static volatile boolean isInExam = false;// �Ƿ��ڿ���ʱ����
	static Map<String, Long> timeUse = new ConcurrentHashMap<>();// ��¼����ʱ��
	static Set<String> lateSet = new CopyOnWriteArraySet<String>();// �������˵�ѧ��
 
	public static void main(String[] args) {
		TestCountDownLatch test = new TestCountDownLatch();
		// ���ĵ��վ���ʦ��������п����ύ�˾��ӣ�������ץ��
		CountDownLatch teacher = new CountDownLatch(StudentNum); 
		// ���Կ�ʼ���źţ���׼��ǰд���ӡ�
		CountDownLatch startExamSignal = new CountDownLatch(1);
		// ���Խ������źţ�û��ʱ�佻���ͬѧ�ᱻ���յ���ʦ�ǵ�lateSet������������ˣ�������ǰ������
		CountDownLatch endExamSignal = new CountDownLatch(StudentNum);
 
		Thread[] threadList = new Thread[StudentNum];
		// ��������
		for (int i = 0; i < StudentNum; i++) {
			threadList[i] = new Thread(test.new Student(
					Integer.toString(10000 + i), startExamSignal, endExamSignal,teacher));
			threadList[i].start();
		}
 
		// �����п������첻̫�Ծ�
		Random random = new Random();
		new Thread(test.new UnexpectedEvent(
				threadList[random.nextInt(StudentNum - 1)], startExamSignal))
				.start();
		isInExam = true;
		// ���Կ�ʼ��
		System.out.println("��ʦ�� ���Կ�ʼ��");
		startExamSignal.countDown();
 
		// ��ʦ���ĵؼ࿼
		try {
			isInExam = endExamSignal.await(2, TimeUnit.SECONDS);// ����ʱ��2��
			System.out.println("��ʦ�����Խ����ˣ�����Ҫд�ˣ���");
			//��ʦ��ʰ�������о���
			teacher.await();
			System.out.println("��ʦ:����������;������û��ʱ����Ŀ�������ֱ�Ӳ����񣡣�");
			System.out.println(lateSet);
		} catch (InterruptedException e) {
			System.out.println("���Ծ�Ȼ�ж��ˣ�����");
			e.printStackTrace();
		}
	}
 
	class Student implements Runnable {
		private String testNum;// ����
		private CountDownLatch startExamSignal;// ���Կ�ʼ���ź�
		private CountDownLatch endExamSignal;// ���Խ������ź�
		private CountDownLatch teacher;// �վ���ʦ
 
		public Student(String testNum, CountDownLatch startExamSignal,
				CountDownLatch endExamSignal,CountDownLatch teacher) {
			this.testNum = testNum;
			this.startExamSignal = startExamSignal;
			this.endExamSignal=endExamSignal;
			this.teacher = teacher;
		}
 
		@Override
		public void run() {
			Random random = new Random();
			int time1 = 1000 + random.nextInt(2000);// 1000~3000
			long startTime=0;
			try {
				startExamSignal.await();// ��׼��ǰ���
				startTime=System.currentTimeMillis();
				Thread.sleep(time1);// д����	
//				System.out.println(teacher.getCount());
			} catch (InterruptedException e) {
				System.out.printf(
						"ѧ��%s�����Ӿ�������ˮ������У����ʲ����ˣ�" + System.lineSeparator(),testNum);
				//�࿼��Ա�����ǵ����ϸ������С�
				lateSet.add(testNum);
				
				e.printStackTrace();
			} finally {
				timeUse.put(testNum,System.currentTimeMillis()-startTime);
				//������ģ��ǵ����ϸ������С�
				if (!isInExam) {
					lateSet.add(testNum);
				}
				System.out.printf("����%s�ύ�˾���" + System.lineSeparator(), testNum);
				teacher.countDown();// ������վ���ʦ
				endExamSignal.countDown();
			}
		}
	}
 
	// ����������ѡһ��ѧ�������񾭴��ң��жϣ�
	class UnexpectedEvent implements Runnable {
		private Thread unfortunatelyStudent;
		private CountDownLatch startExamSignal;// ���Կ�ʼ���ź�
 
		UnexpectedEvent(Thread unfortunatelyStudent,
				CountDownLatch startExamSignal) {
			this.unfortunatelyStudent = unfortunatelyStudent;
			this.startExamSignal = startExamSignal;
		}
 
		@Override
		public void run() {
			try {
				Random random = new Random();
				long timeStart = 1200 + random.nextInt(400);
				
				startExamSignal.await();
				long time = System.currentTimeMillis();
				while (System.currentTimeMillis() - time < timeStart) {
				}
				//�ж�һ���߳�
				unfortunatelyStudent.interrupt();
			} catch (InterruptedException e) {
				System.out.println("�͵�ɶ�¶�û������");
				e.printStackTrace();
			}
		}
	}
}
