package mashibin.udp;

import java.net.*;
import java.io.*;

//����udp
//datagram�����ݱ�

//֪ʶ�㣺udp�������ࣺjava.net:DatagramSocket DatagramPacket��
//byte[]����ת����ء���byte[]תString
//���ĸ�ϰ
class UdpReceive  {
	public static void main(String[] args)throws Exception{
		 //��δ���Ҫ��main���档
		boolean flag=true;
		byte buf[]=new byte[1024];
		DatagramPacket pk=new DatagramPacket(buf,buf.length);
		DatagramSocket ds=new DatagramSocket(8888);
		System.out.println("udp:listen at 8888");
		
		while(flag){
			ds.receive(pk);//����ʽ	
			//����1��ע�������д�� byte[] -->String
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