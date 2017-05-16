// socket 客户端
// 实例化一个socket类Socket client=new Socket("",8080);
// 输入输出：client.getOutputStream   client.getInputStream
package mashibin.tcp;

import java.io.*;
import java.net.*;

public class socketClient {
  public static void main(String[] args){
	  try{
		  // 客户端实例化一个socket类
	  Socket client=new Socket("",8000);
	  // 输入输出
	 
	  DataOutputStream out=new DataOutputStream(client.getOutputStream());
	  out.writeUTF("hello from"+client.getLocalSocketAddress());
	  
	
	  DataInputStream in=new DataInputStream(client.getInputStream());
	  System.out.println(in.readUTF());
	  
  }catch (IOException t){
	  t.printStackTrace();
  }
}
}