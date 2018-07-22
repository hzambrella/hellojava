package TestNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileChannel {
	public static void main(String[] args) throws IOException {
//		test1();
		test2();
	}

	public static void test2() throws IOException {
		int num=3;
		String file = "toRead.txt";
		RandomAccessFile rf=new RandomAccessFile(file,"r");
		FileChannel fc=rf.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(num);//读num个字节到缓冲区

		int c = fc.read(bf);
		while (c != -1) {
			bf.flip();// 写变读
			System.out.println("Read " + c);
			while (bf.hasRemaining()) {
				byte b = bf.get();
				System.out.println(b);
			}
			bf.clear();//清空缓冲区
			c=fc.read(bf);
		}
		
		rf.close();
	}

	public static void test1() throws IOException {
		Path file = Paths.get("toRead.txt");
		FileChannel fc = FileChannel.open(file);
		MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
				fc.size());
		byte[] b = new byte[(int) fc.size()];
		for (int i = 0; i < fc.size(); i++) {
			System.out.println(buffer.get(i));// 没有i的话，后移
			b[i] = buffer.get(i);
		}
		System.out.println(new String(b));
	}
}
