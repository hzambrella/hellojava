package mashibin.udp;

import java.net.*;
import java.io.*;

//接受udp
//datagram：数据报

//知识点：udp的两个类：java.net:DatagramSocket DatagramPacket。
//byte[]类型转化相关。如byte[]转String
//流的复习
class UdpReceive  {
	public static void main(String[] args)throws Exception{
		 //这段代码要在main里面。
		boolean flag=true;
		byte buf[]=new byte[1024];
		DatagramPacket pk=new DatagramPacket(buf,buf.length);
		DatagramSocket ds=new DatagramSocket(8888);
		System.out.println("udp:listen at 8888");
		
		while(flag){
			ds.receive(pk);//阻塞式	
			//问题1：注意这里的写法 byte[] -->String
			String mess=new String(buf,0,pk.getLength());
			System.out.println(mess);
			if (mess.equals("exit")){
				ds.close();
				flag=false;
				System.out.println("bye!");
			}
		}
		
	}
}