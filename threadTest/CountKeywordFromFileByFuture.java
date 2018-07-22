package threadTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//���󣺴�����Ŀ¼������Ŀ¼ͳ���ж��ٸ��ļ������ؼ��֡�ʹ��Future��
public class CountKeywordFromFileByFuture {
	static Set<String> fileNameHaveKeyword=new TreeSet<>();
	
	
	public static void main(String[] args) {
		CountKeywordFromFileByFuture test=new CountKeywordFromFileByFuture();
		Scanner sysin=new Scanner(System.in);
		//e:/HTMLhz/studyhtml/jQuery
		System.out.println("Enter directory you want find");
		//alert
		String directoryRoot=sysin.nextLine();
		System.out.println("Enter keyword you want find");
		String keyword=sysin.nextLine();
		System.out.printf("directory:%s -->key word:%s"+System.lineSeparator(),directoryRoot,keyword);
		sysin.close();	
		
		File rootFile=new File(directoryRoot);
		CountKeywordFromFile ctest=test.new CountKeywordFromFile(keyword,rootFile);
		FutureTask<Integer> future=new FutureTask<>(ctest);
		Thread cThread=new Thread(future);
		cThread.start();
		
		try {
			int count=future.get();
			System.out.println(count);
			System.out.print(fileNameHaveKeyword.size()+":");
			System.out.println(fileNameHaveKeyword);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	class CountKeywordFromFile implements Callable<Integer>{
		String keyword;
		File directory;
		
		CountKeywordFromFile(String keyword,File directory){
			this.keyword=keyword;
			this.directory=directory;
		}
		
		@Override
		public Integer call() throws Exception {
			int count=0;
			List<FutureTask<Integer>> catchTasks=new ArrayList<>();

			File[] subDir=directory.listFiles();
			
			//�ȱ�����ǰĿ¼�µ��ļ���
			for (File file:subDir){
				//�������Ŀ¼���ٿ����̣߳���FutureTask��װ��������
				if (file.isDirectory()){
					CountKeywordFromFile sub=new CountKeywordFromFile(keyword,file);
					FutureTask<Integer> task=new FutureTask<>(sub);
					catchTasks.add(task);
					Thread subThread=new Thread(task);
					subThread.start();
				}else{
					if(isContainKeywordInFile(file))count++;
				}
			}
			
			for(FutureTask<Integer> task:catchTasks){
				count+=task.get();//����ʽ�ġ�ͳ�Ƹ�����Ŀ¼�Ľ����
			}
			
			return count;
		}
		
		public boolean isContainKeywordInFile(File file) throws FileNotFoundException{
			boolean haveKeyword=false;
			Scanner scanner=new Scanner(new FileInputStream(file));
//			while (scanner.hasNext()){
			while (scanner.hasNext()&&!haveKeyword){ //���õ�д��������break��
				String line=scanner.nextLine();
//				if (line.contains(keyword)){
//					haveKeyword=true;
//					break;
//				}
				if (line.contains(keyword)){
					fileNameHaveKeyword.add(file.getAbsolutePath());
					haveKeyword=true;
				}
			}
			
			
			scanner.close();
			return haveKeyword;
		}
	}
}
