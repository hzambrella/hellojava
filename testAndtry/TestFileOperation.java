package testAndtry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

import com.alibaba.fastjson.JSON;

public class TestFileOperation {

	public static void main(String[] args) {
		File f = new File("test.txt");
		File f2 = new File("test2.txt");
		File f3 = new File("test3.txt");

		System.out.println(f.getAbsolutePath() + " " + f2.getAbsolutePath());
		String content = " test file io" + System.getProperty("line.separator");
		StringBuffer contents = new StringBuffer();
		for (int i = 0; i < 999999; i++) {
			contents.append(content);
		}
		content = contents.toString();

		try {
			if (!f2.exists()) {
				f2.createNewFile();
			}

			if (!f3.exists()) {
				f3.createNewFile();
			}
			// true����׷��
			FileOutputStream fout = new FileOutputStream(f, false);
			fout.write(content.getBytes());
			fout.close();

			// ��ȡtest.txt���ݣ����Ƶ�test2.txt
			{
				long start = System.currentTimeMillis();
				FileInputStream fin = new FileInputStream(f);
				System.out.println("byte[]�ĳ���" + fin.available());
				byte[] b = new byte[fin.available()];
				while (fin.read(b) != -1) {
				}
				;

				FileOutputStream fout2 = new FileOutputStream(f2);
				fout2.write(b);

				fin.close();
				fout2.close();
				long end = System.currentTimeMillis();
				System.out.println("��ʱ:" + (end - start) + "����");
			}

			{
				long start = System.currentTimeMillis();
				FileReader f3Reader = new FileReader(f);
				BufferedReader br = new BufferedReader(f3Reader);
				char[] cb = new char[14999985];
				br.read(cb);
				FileWriter fwrite = new FileWriter(f3);
				String line = null;

				/*
				 * while((line=br.readLine())!=null){ fwrite.write(line);
				 * fwrite.write(System.getProperty("line.separator"));
				 * fwrite.flush(); }
				 */

				fwrite.write(cb);
				br.close();
				fwrite.close();
				long end = System.currentTimeMillis();
				System.out.println("��ʱ:" + (end - start) + "����");
			}

			{
				System.out.println("Stream ��byte[] �Ĳ���");
				File fRead = new File("toRead.txt");
				File fWrite = new File("toWrite.txt");
				FileInputStream fin2 = new FileInputStream(fRead);
				if (fin2.available() != 0) {
					FileOutputStream fout2 = new FileOutputStream(fWrite);
					byte[] tmp = new byte[5];
					
					int len=-1;
					while((len=fin2.read(tmp))!=-1){
						System.out.println(len);
						System.out.println("before write"+tmp.length);

						fout2.write(tmp);
						System.out.println("after write"+tmp.length);

					}
				}else{
					System.out.println("�����ļ�Ϊ��");
				}
			}
			
			{
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* FileInputStream f=new FileInputStream(); */
	}
}
