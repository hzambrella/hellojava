package mashibin.udp;

import java.io.*;
import java.net.*;
//udp
public class UdpSend {
	public static void main(String[] args)throws Exception{
		boolean flag=true;
		//问题1
		//DataInputStream dis=new DataInputStream(System.in)
		//str=dis.readUTF();
		//没用！？
		//解决：改为下面的写法。以后都这样写。
		BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
		
		//不用重复new对象。
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
			
			//byte buf[]=new String(str).getBytes();	//注意写法
			//问题1：怎么发送
			//DatagramPacket pk=new DatagramPacket
			//(buf,buf.length,new InetSocketAddress("127.0.0.1", 8888));
			// 问题2：DatagramSocket ds=new DatagramSocket
			//(8080)为什么 Address already in use: Cannot bind;
			ds.send(pk);
			if (str.equals("exit")){
				flag=false;
				System.out.println("send:bye!");
				ds.close();
			}
			
		}
	}
}
