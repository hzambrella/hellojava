package TestNIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ZipFileSystem {
	public static void main(String[] args) throws IOException {
		File f=new File("commons-io-2.5.jar");
		FileSystem fs=FileSystems.newFileSystem(Paths.get(f.getAbsolutePath()), null);
		Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
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
