package TestNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class TestPipe2 {
	boolean flag=false;//true代表没数据了。
	public static void main(String[] args) throws IOException {
		Pipe pipe = Pipe.open();
		TestPipe2 test = new TestPipe2();
		Thread t1 = new Thread(test.new TestPipeThread1("t1", pipe));
		Thread t2 = new Thread(test.new TestPipeThread2("t2", pipe));
		t1.start();
		t2.start();
	}

	class TestPipeThread {
		private String data;
		private Pipe pipe;

		public TestPipeThread(String data, Pipe pipe) {
			this.data = data;
			this.pipe = pipe;
		}

		public String getData() {
			return this.data;
		}

		public Pipe getPipe() {
			return this.pipe;
		}
	}

	class TestPipeThread1 extends TestPipeThread implements Runnable {
		public TestPipeThread1(String data, Pipe pipe) {
			super(data, pipe);
		}

		public String getData() {
			return super.getData();
		}

		@Override
		public void run() {
			try (RandomAccessFile file = new RandomAccessFile(
					"toReadMiddle.txt", "r")) {
				FileChannel channel = file.getChannel();
				Pipe pipe = super.getPipe();
				SinkChannel sink = pipe.sink();
				
				ByteBuffer buf = ByteBuffer.allocate(8);
				int byteRead;
				
				while((byteRead=channel.read(buf))!=-1){// 数据写入buf
					buf.flip();// buf转入读模式
					while (buf.hasRemaining()) {
						sink.write(buf);// 把数据放入sinkChannel
					}
					buf.clear();
				}
				file.close();
				sink.close();//记得关闭
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class TestPipeThread2 extends TestPipeThread implements Runnable {
		public TestPipeThread2(String data, Pipe pipe) {
			super(data, pipe);
		}

		public String getData() {
			return super.getData();
		}

		@Override
		public void run() {
			Pipe pipe = super.getPipe();
			SourceChannel source = pipe.source();
			ByteBuffer buf = ByteBuffer.allocate(8);
			try {
				int byteRead;// sourceChannel的数据写入buf
				while ((byteRead=source.read(buf)) != -1) {
					buf.flip();// buf转入读模式
					while (buf.hasRemaining()) {
						System.out
								.print(new String(new byte[] { buf.get() }));
					}
					buf.clear();// 清空buf
				}
				source.close();//记得关闭
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
