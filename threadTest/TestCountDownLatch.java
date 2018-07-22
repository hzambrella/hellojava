package threadTest;
 
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
 
public class TestCountDownLatch {
	final static int StudentNum = 20;// 线程数
	static volatile boolean isInExam = false;// 是否在考试时间内
	static Map<String, Long> timeUse = new ConcurrentHashMap<>();// 记录交卷时间
	static Set<String> lateSet = new CopyOnWriteArraySet<String>();// 交卷交晚了的学生
 
	public static void main(String[] args) {
		TestCountDownLatch test = new TestCountDownLatch();
		// 耐心的收卷老师。会等所有考生提交了卷子，而不是抓卷。
		CountDownLatch teacher = new CountDownLatch(StudentNum); 
		// 考试开始的信号，不准提前写卷子。
		CountDownLatch startExamSignal = new CountDownLatch(1);
		// 考试结束的信号，没按时间交卷的同学会被阴险的老师记到lateSet。如果都交卷了，考试提前结束。
		CountDownLatch endExamSignal = new CountDownLatch(StudentNum);
 
		Thread[] threadList = new Thread[StudentNum];
		// 考生进场
		for (int i = 0; i < StudentNum; i++) {
			threadList[i] = new Thread(test.new Student(
					Integer.toString(10000 + i), startExamSignal, endExamSignal,teacher));
			threadList[i].start();
		}
 
		// 好像有考生今天不太对劲
		Random random = new Random();
		new Thread(test.new UnexpectedEvent(
				threadList[random.nextInt(StudentNum - 1)], startExamSignal))
				.start();
		isInExam = true;
		// 考试开始！
		System.out.println("老师： 考试开始！");
		startExamSignal.countDown();
 
		// 老师无聊地监考
		try {
			isInExam = endExamSignal.await(2, TimeUnit.SECONDS);// 考试时间2秒
			System.out.println("老师：考试结束了！！不要写了！！");
			//老师收拾好了所有卷子
			teacher.await();
			System.out.println("老师:下面宣布中途弃考和没按时交卷的考生！！直接不及格！！");
			System.out.println(lateSet);
		} catch (InterruptedException e) {
			System.out.println("考试居然中断了！！！");
			e.printStackTrace();
		}
	}
 
	class Student implements Runnable {
		private String testNum;// 考号
		private CountDownLatch startExamSignal;// 考试开始的信号
		private CountDownLatch endExamSignal;// 考试结束的信号
		private CountDownLatch teacher;// 收卷老师
 
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
				startExamSignal.await();// 不准提前答卷。
				startTime=System.currentTimeMillis();
				Thread.sleep(time1);// 写卷子	
//				System.out.println(teacher.getCount());
			} catch (InterruptedException e) {
				System.out.printf(
						"学生%s：电子竞技处于水深火热中！劳资不考了！" + System.lineSeparator(),testNum);
				//监考人员把他记到不合格名单中。
				lateSet.add(testNum);
				
				e.printStackTrace();
			} finally {
				timeUse.put(testNum,System.currentTimeMillis()-startTime);
				//交卷交晚的，记到不合格名单中。
				if (!isInExam) {
					lateSet.add(testNum);
				}
				System.out.printf("考生%s提交了卷子" + System.lineSeparator(), testNum);
				teacher.countDown();// 交卷给收卷老师
				endExamSignal.countDown();
			}
		}
	}
 
	// 神秘力量挑选一个学生让他神经错乱（中断）
	class UnexpectedEvent implements Runnable {
		private Thread unfortunatelyStudent;
		private CountDownLatch startExamSignal;// 考试开始的信号
 
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
				//中断一个线程
				unfortunatelyStudent.interrupt();
			} catch (InterruptedException e) {
				System.out.println("就当啥事都没发生过");
				e.printStackTrace();
			}
		}
	}
}
