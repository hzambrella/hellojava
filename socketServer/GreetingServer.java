// socket ������

// ���裺
// ʵ����һ��serverSocket����
// ���� serverSocket���accept����
// ����ͻ������ӳɹ���accept() ����һ��socket
// socket�������������

// socket ������
/*
���	��������
1	public void connect(SocketAddress host, int timeout) throws IOException
�����׽������ӵ�����������ָ��һ����ʱֵ��
2	public InetAddress getInetAddress()
 �����׽������ӵĵ�ַ��
3	public int getPort()
���ش��׽������ӵ���Զ�̶˿ڡ�
4	public int getLocalPort()
���ش��׽��ְ󶨵��ı��ض˿ڡ�
5	public SocketAddress getRemoteSocketAddress()
���ش��׽������ӵĶ˵�ĵ�ַ�����δ�����򷵻� null��
6	public InputStream getInputStream() throws IOException
���ش��׽��ֵ���������
7	public OutputStream getOutputStream() throws IOException
���ش��׽��ֵ��������
8	public void close() throws IOException
�رմ��׽��֡�
*/

package socketServer;

import java.io.*;
import java.net.*;


public class GreetingServer extends Thread {

	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		// ������Ӧ�ó���ͨ��ʹ�� java.net.ServerSocket ���Ի�ȡһ���˿�,���������ͻ�������
		 serverSocket.setSoTimeout(999999999);
		// ͨ��ָ����ʱֵ����/���� SO_TIMEOUT���Ժ���Ϊ��λ��

	}

	
	
	public void run() {
		while (true) {
			try {
				System.out.println("waiting for client on port:" +serverSocket.getLocalPort() + ".....");// serverSocket�ı��ض˿�
				
				// ���������ܵ����׽��ֵ����ӡ�public Socket accept() throws IOException
				Socket server = serverSocket.accept();
				
				//���ش��׽������ӵĶ˵�ĵ�ַ�����δ�����򷵻� null��
				System.out.println("just connect to" + server.getRemoteSocketAddress());
				
				// ���ش��׽��ֵ���������
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				// �����
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you fot connecting to" + server.getLocalSocketAddress() + "\nGoodbye!");
				
				// �ر�
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
			// ���߳� Ҳ����д�� Thread t=new GreetingServer(port)
			GreetingServer t = new GreetingServer(port);
			// �߳̿���
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
