// socket 服务器

// 步骤：
// 实例化一个serverSocket对象
// 调用 serverSocket类的accept方法
// 如果客户端链接成功，accept() 创建一个socket
// socket进行输入输出：

// socket 方法：
/*
序号	方法描述
1	public void connect(SocketAddress host, int timeout) throws IOException
将此套接字连接到服务器，并指定一个超时值。
2	public InetAddress getInetAddress()
 返回套接字连接的地址。
3	public int getPort()
返回此套接字连接到的远程端口。
4	public int getLocalPort()
返回此套接字绑定到的本地端口。
5	public SocketAddress getRemoteSocketAddress()
返回此套接字连接的端点的地址，如果未连接则返回 null。
6	public InputStream getInputStream() throws IOException
返回此套接字的输入流。
7	public OutputStream getOutputStream() throws IOException
返回此套接字的输出流。
8	public void close() throws IOException
关闭此套接字。
*/

package socketServer;

import java.io.*;
import java.net.*;


public class GreetingServer extends Thread {

	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		// 服务器应用程序通过使用 java.net.ServerSocket 类以获取一个端口,并且侦听客户端请求。
		 serverSocket.setSoTimeout(999999999);
		// 通过指定超时值启用/禁用 SO_TIMEOUT，以毫秒为单位。

	}

	
	
	public void run() {
		while (true) {
			try {
				System.out.println("waiting for client on port:" +serverSocket.getLocalPort() + ".....");// serverSocket的本地端口
				
				// 侦听并接受到此套接字的连接。public Socket accept() throws IOException
				Socket server = serverSocket.accept();
				
				//返回此套接字连接的端点的地址，如果未连接则返回 null。
				System.out.println("just connect to" + server.getRemoteSocketAddress());
				
				// 返回此套接字的输入流。
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				// 输出流
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you fot connecting to" + server.getLocalSocketAddress() + "\nGoodbye!");
				
				// 关闭
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// int port = Integer.parseInt(args[0]);
		int port =8000;
		try {
			// 多线程 也可以写成 Thread t=new GreetingServer(port)
			GreetingServer t = new GreetingServer(port);
			// 线程开启
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
