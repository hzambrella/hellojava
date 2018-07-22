package TestNIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.*;

//e:/HTMLhz/studyhtml/jQuery
public class WalkDir {
	public static void main(String[] args) throws IOException {
		Path start=Paths.get("e:/HTMLhz");
	    Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
	         @Override
	         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	             throws IOException
	         {
	        	 System.out.print(file+" size:");
	        	 System.out.println(attrs.size());
	             return FileVisitResult.CONTINUE;
	         }
	         @Override
	         public FileVisitResult postVisitDirectory(Path dir, IOException e)
	             throws IOException
	         {
	             if (e == null) {
	                 return FileVisitResult.CONTINUE;
	             } else {
	                 // directory iteration failed
	                 throw e;
	             }
	         }
	     });
	}
}
