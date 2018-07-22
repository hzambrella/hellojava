package TestNIO;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class TestReadMethod {
	public static long checkInputStream(Path fileName) throws IOException{
		try(InputStream in=Files.newInputStream(fileName)){
			CRC32 crc=new CRC32();
			int c;
			while((c=in.read())!=-1){
//				System.out.println(c);
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checkBufferedInputStream(Path fileName) throws IOException{
		try(InputStream in=new BufferedInputStream(Files.newInputStream(fileName))){
			CRC32 crc=new CRC32();
			int c;
			while((c=in.read())!=-1){
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checkRandomAccessFile(Path fileName) throws FileNotFoundException, IOException{
		try(RandomAccessFile ra=new RandomAccessFile(fileName.toFile(),"r")){
			CRC32 crc=new CRC32();
			long length=ra.length();
			for (int i=0;i<length;i++){
				ra.seek(i);
				int c=ra.readByte();
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checkChannel(Path fileName) throws IOException{
		CRC32 crc=new CRC32();
		try(FileChannel channel=FileChannel.open(fileName)){
			int size=(int) channel.size();
			MappedByteBuffer buffer=channel.map(FileChannel.MapMode.READ_ONLY, 0, size);
			for (int i=0;i<size;i++){
				int c=buffer.get(i);
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Path fileName=Paths.get("test.txt");
		long start=0;
		long end=0;
		start=System.currentTimeMillis();
		long result1=checkInputStream(fileName);
		end=System.currentTimeMillis();
		System.out.println(result1+"-"+(end-start));
		
		start=System.currentTimeMillis();
		long result2=checkBufferedInputStream(fileName);
		end=System.currentTimeMillis();
		System.out.println(result2+"-"+(end-start));
		
		start=System.currentTimeMillis();
		long result3=checkRandomAccessFile(fileName);
		end=System.currentTimeMillis();
		System.out.println(result3+"-"+(end-start));
		
		start=System.currentTimeMillis();
		long result4=checkChannel(fileName);
		end=System.currentTimeMillis();
		System.out.println(result4+"-"+(end-start));
	}
	
}
