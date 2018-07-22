package TestNIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

//e:/HTMLhz/studyhtml/jQuery
public class TestDirTree {
	public static void main(String[] args) {
		try(DirectoryStream<Path> entries=Files.newDirectoryStream(Paths.get("e:/HTMLhz/studyhtml/jQuery"))){
			for (Path entry:entries){
				if(Files.readAttributes(entry, BasicFileAttributes.class).isDirectory()){
					System.out.print("dir:");
				}else{
					System.out.print("file:");
				}
				System.out.println(entry.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
