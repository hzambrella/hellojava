package TestNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestTransform {
	public static void main(String[] args) throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("toRead.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		RandomAccessFile toFile = new RandomAccessFile("toWrite.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		fromChannel.transferTo(3, 2, toChannel);
		toChannel.transferFrom(fromChannel, 0, 5);
		
	}
}
