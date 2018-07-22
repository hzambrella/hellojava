package threadTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


//�������С���������ģʽ��
//���󣺴�����Ŀ¼������Ŀ¼�ҵ������ؼ��֣���ӡ�ļ���·����������
public class FindKeywordFromFileByBlockQueueTest {
	private final static int SEARCH_QUEUE=10;
	private final static int THREAD_TOFIND_KEYWORD=100;
	private final static File EndFlagFile=new File("");
	static BlockingQueue<File> blockQueueTask=new ArrayBlockingQueue<>(SEARCH_QUEUE);;
	
	public static void main(String[] args) {
		FindKeywordFromFileByBlockQueueTest test=new FindKeywordFromFileByBlockQueueTest();
		Scanner sysin=new Scanner(System.in);
		//e:/HTMLhz/studyhtml/jQuery
		System.out.println("Enter directory you want find");
		//alert
		String directoryRoot=sysin.nextLine();
		System.out.println("Enter keyword you want find");
		String keyword=sysin.nextLine();
		System.out.printf("directory:%s -->key word:%s"+System.lineSeparator(),directoryRoot,keyword);
		sysin.close();
		
		FileEnumerationTask fileEnumerationTask=test.new FileEnumerationTask(blockQueueTask,directoryRoot);
		Thread feThread=new Thread(fileEnumerationTask);
		for (int i=0;i<THREAD_TOFIND_KEYWORD;i++){
			SearchTask searchtask=test.new SearchTask(blockQueueTask, keyword);
			Thread stThread=new Thread(searchtask);
			stThread.start();
		}
		feThread.start();
	}
	
	//������Ŀ¼������Ŀ¼�µ��ļ��������������С�
	class FileEnumerationTask implements Runnable{
		BlockingQueue<File> blockQueueTask;
		String directoryStart;
		
		
		public FileEnumerationTask(BlockingQueue<File> blockQueueTask,String directoryStart){
			this.blockQueueTask=blockQueueTask;
			this.directoryStart=directoryStart;
		}
		
		@Override
		public void run() {
			File dirToStart=new File(directoryStart);
			try {
				enumFile(dirToStart);
				blockQueueTask.put(EndFlagFile);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void enumFile(File dirToStart) throws InterruptedException{
			if (dirToStart.exists()){
				File[] listFiles=dirToStart.listFiles();
				for (File file:listFiles){
					if (file.isDirectory()){
						enumFile(file);
					}else{
						blockQueueTask.put(file);
					}
				}
			}else{
				System.out.printf("warning start dir: %s is not found"+System.lineSeparator(),directoryStart);
			}
		}
	}
	
	//���������ļ������Ƿ�����ؼ���
	class SearchTask implements Runnable{
//		String fileName;
		BlockingQueue<File>blockQueueTask;
		String keyword;
		
		SearchTask(	BlockingQueue<File> blockQueueTask,String keyword){
			this.blockQueueTask=blockQueueTask;
			this.keyword=keyword;
		}
		
		@Override
		public void run() {
			boolean canStop=false;
			try {
				while(!canStop){
					File file=blockQueueTask.take();
					if (file!=EndFlagFile){
						searchKeywordFromFile(file);
					}else{
						blockQueueTask.put(file);
						canStop=true;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private void searchKeywordFromFile(File file) throws FileNotFoundException{
			Scanner scanner=new Scanner(new FileInputStream(file));
			int linenumber=0;
			while(scanner.hasNext()){
				String line=scanner.nextLine();
				linenumber++;
				if (line.contains(keyword)){
					System.out.printf("[%s]:(line:%d)"+System.lineSeparator(),file.getAbsolutePath(),linenumber);
				};
			}
			
			scanner.close();
		}
		
	}
}
