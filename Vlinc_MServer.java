import java.io.*;
import java.net.*;

public class Vlinc_MServer {
	static int clintNum = 1;
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket client = null;
		while(true){
			try{
				serverSocket = new ServerSocket(6060);
			}catch(Exception e){
				System.out.println("Error: "+ e);
				System.exit(-1);
			}
			try{
				client = serverSocket.accept();
			}catch(Exception e){
				System.out.println("Error: " + e);
				System.exit(-1);
			}
			System.out.println("好友:" + Vlinc_MServer.clintNum + "登录");
			ServerThread st = new ServerThread(client);
			Thread t = new Thread(st);
			t.start();
			try{
				serverSocket.close();
			}catch (IOException e){
				System.out.println("Close Failure!");
			}
			clintNum++;
		}
	}
}
class ServerThread implements Runnable{
	private Socket client;
	public ServerThread(Socket client){
		this.client = client;
	}
	public void run () {
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter os = new PrintWriter(client.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("对方说：" + is.readLine());
			String inputString = sin.readLine();
			while(inputString != null && !inputString.trim().equals("quit chat")){
				os.println(inputString);
				os.flush();
				System.out.println("我说：" + inputString);
				System.out.println("对方说：" + is.readLine());
				inputString = sin.readLine();
			}
			os.close();
			is.close();
			client.close();
			System.out.println("聊天结束！");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
