package mashibin.udp;

import java.io.*;
import java.net.*;
//udp
public class UdpSend {
	public static void main(String[] args)throws Exception{
		boolean flag=true;
		//����1
		//DataInputStream dis=new DataInputStream(System.in)
		//str=dis.readUTF();
		//û�ã���
		//�������Ϊ�����д�����Ժ�����д��
		BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
		
		//�����ظ�new����
		byte buf[]=new byte[1024];
		DatagramPacket pk=new DatagramPacket(buf,buf.length);
		pk.setSocketAddress(new InetSocketAddress("127.0.0.1", 8888));
		DatagramSocket ds=new DatagramSocket(9999);
		
		while(flag){	
			String str=dis.readLine();
			//System.out.println("str:"+str);
			//String-->byte[]
			buf=str.getBytes();
			pk.setData(buf);
			
			//byte buf[]=new String(str).getBytes();	//ע��д��
			//����1����ô����
			//DatagramPacket pk=new DatagramPacket
			//(buf,buf.length,new InetSocketAddress("127.0.0.1", 8888));
			// ����2��DatagramSocket ds=new DatagramSocket
			//(8080)Ϊʲô Address already in use: Cannot bind;
			ds.send(pk);
			if (str.equals("exit")){
				flag=false;
				System.out.println("send:bye!");
				ds.close();
			}
			
		}
	}
}
