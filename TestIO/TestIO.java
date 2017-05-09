package TestIO;

import java.io.*;
import java.util.Date;
//IO
//�ڵ��� InputStream OutputStream
//������ ������  ת���� ������  print��  ���л�
// ����Ŀ�꣺�ļ���File,�ڴ�������ByteArray
//System.out ��PrintStream
//System.in ��InputStream

public class TestIO {
	public static void main(String[] args){
		System.out.println("��ϰIO");
		//----- ��ϰ1�� ��־----------
		//practice1();
		//------��ϰ2���ڴ�byteArray-----
		//practice2();
		//----��ϰ3�����л�------------
		//practice3();
	}
	
	public static void practice1(){
		
		//----- ��ϰ1�� ��־----------
		String s;
		//����1:���ע���õ�ת��������Ϊ�������Ĺ��췽�����ղ��������й涨��
		BufferedReader bis=new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("start 1");
			// ����2���ļ�����ע���ļ�λ�á�true�������ǡ�
			FileOutputStream fos=new FileOutputStream("log.txt",true);
			// print����
			PrintStream ps=new PrintStream(fos);
			//����3��ע��д��
				while((s=bis.readLine())!=null){
				// String�ķ���
					if (s.equalsIgnoreCase("exit")){
						//����4��������flush��close
						//����5��ʱ���ӡ
						ps.println("---"+new Date()+"----");
						ps.flush();
						ps.close();
						fos.flush();
						fos.close();
						bis.close();
						System.out.println("close!");
						break;
					}
				// ����6��д��log.txt
				ps.println(s);
				}
			}catch(IOException e){
				e.printStackTrace();
				return;
			}	
	}//��ϰ1 end
	
	public static void practice2(){
		//�ڴ�����byte���顣
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
			try {
				dos.writeUTF("�������");
				dos.writeBoolean(false);
				dos.writeByte(32);
				dos.writeDouble(2.0);
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
			//����1��ע�� toByteArray()����
			ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
			System.out.println("bais.available()"+bais.available());
			DataInputStream dis=new DataInputStream(bais);
			try {
				
				//����2����ôread
				System.out.println(dis.readUTF());
				System.out.println(dis.readBoolean());
				System.out.println(dis.readByte());
				System.out.println(dis.readDouble());
				
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
		
			//����3��������close
			try {
				baos.close();
				bais.close();
				dos.close();
				dis.close();
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
		}//�ڴ�����end
	
	//----��ϰ3�����л�------------
		public static void practice3(){
			T t=new T();
			System.out.println("���л�ǰ"+t);
			t.setid(20);
			//t.weight=100.23;
			t.name="�������";
			try{
				//serializible
				FileOutputStream fos=new FileOutputStream("Serializable.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				//����1����ô���л�
				oos.writeObject(t);
				fos.close();
				oos.flush();
				oos.close();
				
				//unserializible
				FileInputStream fis=new FileInputStream("Serializable.txt");
				ObjectInputStream ois=new ObjectInputStream(fis);
				//����2����ô�����л�
				T t2=(T)ois.readObject();
				System.out.println("���л�ǰ"+t2);
				fis.close();
				ois.close();
				
			}catch (FileNotFoundException f){
				System.out.println("�ļ�δ�ҵ���");
				f.printStackTrace();
			}catch (ClassNotFoundException c){
				System.out.println("�����л�����δ�ҵ�");
				c.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
				return;
			}
			
		}//���л�end
}//class TestIO

class T implements Serializable{
	private int id=1;
	public String name="����";
	//���⣺transient����
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
	




