// socket �ͻ���
// ʵ����һ��socket��Socket client=new Socket("",8080);
// ���������client.getOutputStream   client.getInputStream
package mashibin.tcp;

import java.io.*;
import java.net.*;

public class socketClient {
  public static void main(String[] args){
	  try{
		  // �ͻ���ʵ����һ��socket��
	  Socket client=new Socket("",8000);
	  // �������
	 
	  DataOutputStream out=new DataOutputStream(client.getOutputStream());
	  out.writeUTF("hello from"+client.getLocalSocketAddress());
	  
	
	  DataInputStream in=new DataInputStream(client.getInputStream());
	  System.out.println(in.readUTF());
	  
  }catch (IOException t){
	  t.printStackTrace();
  }
}
}