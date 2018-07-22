package TestNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class TestPipe {
	public static void main(String[] args) throws IOException {
		Pipe pipe=Pipe.open();
		TestPipe test=new TestPipe();
		Thread t1=new Thread(test.new TestPipeThread1("t1",pipe));
		Thread t2=new Thread(test.new TestPipeThread2("t2",pipe));
		t1.start();
		t2.start();
	}
	
	class TestPipeThread{
		private String data;
		private Pipe pipe;
		public TestPipeThread(String data,Pipe pipe){
			this.data=data;
			this.pipe=pipe;
		}
		
		public String getData(){
			return this.data;
		}
		
		public Pipe getPipe(){
			return this.pipe;
		}
	}
	
	
	class TestPipeThread1 extends TestPipeThread implements Runnable{
		public TestPipeThread1(String data,Pipe pipe){
			super(data,pipe);
		}
		
		public String getData(){
			return super.getData();
		}
		
		@Override
		public void run() {
			Pipe pipe=super.getPipe();
			SinkChannel sink=pipe.sink();
			ByteBuffer buf=ByteBuffer.allocate(8);
			buf.put(new String("afddas").getBytes());//数据写入buf
			buf.flip();//buf转入读模式
			try {
				while(buf.hasRemaining()){
					sink.write(buf);//把数据放入sinkChannel
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class TestPipeThread2 extends TestPipeThread implements Runnable{
		public TestPipeThread2(String data,Pipe pipe){
			super(data,pipe);
		}
		
		public String getData(){
			return super.getData();
		}
		
		@Override
		public void run() {
			Pipe pipe=super.getPipe();
			SourceChannel source=pipe.source();
			ByteBuffer buf=ByteBuffer.allocate(8);
			try {
				int byteRead=source.read(buf);//sourceChannel的数据写入buf
				while(byteRead!=-1){
					buf.flip();//buf转入读模式
					while(buf.hasRemaining()){
						System.out.println(new String(new byte[]{buf.get()}));
					}
					buf.clear();//清空buf
					byteRead=source.read(buf);//继续从sourceChannel读入数据到buf
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}