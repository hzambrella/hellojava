package TestNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//联系NIO的用法
public class PracticeNIO {
	public static void main(String[] args) throws IOException {
		practicePath();
		practiceFiles();
		practiceDir();
		practiceWalkDir();
		practiceBuffer();
		practiceChannel();
	}
	
	public static void practicePath(){
		Path path=Paths.get("TestNIO","TestPipe.java");
		System.out.println(Files.exists(path));
	}
	
	public static void practiceFiles() throws IOException{
		Path path=Paths.get("TestNIO","TestPipe.java");
		System.out.println(Files.readAttributes(path,BasicFileAttributes.class).size());
	}
	
	public static void practiceDir() throws IOException{
		Path start=Paths.get("f:/HTMLhz/studyhtml");
		DirectoryStream<Path>files=Files.newDirectoryStream(start);
		for (Path file:files){
			System.out.println(file.getFileName());
		}
	}
	
	public static void practiceWalkDir() throws IOException{
		Path start=Paths.get("f:/HTMLhz/studyhtml/jquery");
		Files.walkFileTree(start, new SimpleFileVisitor<Path>(){
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
				System.out.println(file);
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	
	public static void practiceBuffer() throws IOException{
		RandomAccessFile file=new RandomAccessFile("toRead.txt","r");
		FileChannel channel=file.getChannel();
		ByteBuffer buf=ByteBuffer.allocate(2);
		
		int len=channel.read(buf);
		while(len!=-1){
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			buf.clear();
			len=channel.read(buf);
		}
		System.out.print(System.lineSeparator());
	}
	
	//MapedByteBuffer
	public static void practiceChannel() throws IOException{
		FileChannel channel=FileChannel.open(Paths.get("toRead.txt"));
		MappedByteBuffer buf=channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
		
		for (int i=0;i<channel.size();i++){
			System.out.print((char)buf.get(i));
		}
		System.out.print(System.lineSeparator());
	}
	
}
