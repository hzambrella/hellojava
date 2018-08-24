package threadTest;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TestReentrantReadWriteLock {
	public static void main(String[] args) {
		ReentrantReadWriteLock lock=new  ReentrantReadWriteLock ();
		ReadLock read=lock.readLock();
		WriteLock write=lock.writeLock();
		
		int num=(int)Math.pow(2,16);
		System.out.println(num>>>16);
		
		read.lock();
		read.unlock();
		
		write.lock();
		write.unlock();
		
	}
}
