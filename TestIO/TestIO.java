package TestIO;

import java.io.*;
import java.util.Date;
//IO
//节点流 InputStream OutputStream
//处理流 缓存流  转换流 数据流  print流  序列化
// 根据目标：文件流File,内存流。如ByteArray
//System.out 是PrintStream
//System.in 是InputStream

public class TestIO {
	public static void main(String[] args){
		System.out.println("练习IO");
		//----- 练习1， 日志----------
		//practice1();
		//------练习2，内存byteArray-----
		//practice2();
		//----练习3：序列化------------
		//practice3();
	}
	
	public static void practice1(){
		
		//----- 练习1， 日志----------
		String s;
		//问题1:这里，注意用到转换流。因为缓冲流的构造方法接收参数类型有规定。
		BufferedReader bis=new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("start 1");
			// 问题2：文件流，注意文件位置。true代表不覆盖。
			FileOutputStream fos=new FileOutputStream("log.txt",true);
			// print流。
			PrintStream ps=new PrintStream(fos);
			//问题3：注意写法
				while((s=bis.readLine())!=null){
				// String的方法
					if (s.equalsIgnoreCase("exit")){
						//问题4：别忘了flush和close
						//问题5：时间打印
						ps.println("---"+new Date()+"----");
						ps.flush();
						ps.close();
						fos.flush();
						fos.close();
						bis.close();
						System.out.println("close!");
						break;
					}
				// 问题6：写到log.txt
				ps.println(s);
				}
			}catch(IOException e){
				e.printStackTrace();
				return;
			}	
	}//练习1 end
	
	public static void practice2(){
		//内存来块byte数组。
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
			try {
				dos.writeUTF("草拟吗比");
				dos.writeBoolean(false);
				dos.writeByte(32);
				dos.writeDouble(2.0);
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
			//问题1：注意 toByteArray()方法
			ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
			System.out.println("bais.available()"+bais.available());
			DataInputStream dis=new DataInputStream(bais);
			try {
				
				//问题2：怎么read
				System.out.println(dis.readUTF());
				System.out.println(dis.readBoolean());
				System.out.println(dis.readByte());
				System.out.println(dis.readDouble());
				
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
		
			//问题3：别忘了close
			try {
				baos.close();
				bais.close();
				dos.close();
				dis.close();
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
		}//内存数组end
	
	//----练习3：序列化------------
		public static void practice3(){
			T t=new T();
			System.out.println("序列化前"+t);
			t.setid(20);
			//t.weight=100.23;
			t.name="捏儿哈哈";
			try{
				//serializible
				FileOutputStream fos=new FileOutputStream("Serializable.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				//问题1：怎么序列化
				oos.writeObject(t);
				fos.close();
				oos.flush();
				oos.close();
				
				//unserializible
				FileInputStream fis=new FileInputStream("Serializable.txt");
				ObjectInputStream ois=new ObjectInputStream(fis);
				//问题2：怎么反序列化
				T t2=(T)ois.readObject();
				System.out.println("序列化前"+t2);
				fis.close();
				ois.close();
				
			}catch (FileNotFoundException f){
				System.out.println("文件未找到！");
				f.printStackTrace();
			}catch (ClassNotFoundException c){
				System.out.println("反序列化的类未找到");
				c.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
		}//序列化end
}//class TestIO

class T implements Serializable{
	private int id=1;
	public String name="哈哈";
	//问题：transient放哪
	public transient double weight=56.1;
	
	public int getid(){
		return this.id;
	}
	public void setid(int id){
		this.id=id;
	}
	
	public String toString(){
		return "id:"+this.id
				+" name:"+this.name
				+" weight"+this.weight;
	}
}//class T
	




