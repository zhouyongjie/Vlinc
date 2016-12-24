import java.io.*;
import java.net.*;

public class Vlinc_Server {
	public static void main(String argsp[]){
		try{
			ServerSocket server = null;
			try{
				server = new ServerSocket(6060);                        //创建ServerSocket监听6060端口
			}catch (Exception e){
				System.out.println("Error:" + e);
				System.exit(-1);
			}
			Socket client = null;
			try{
				client = server.accept();
			}
			catch(Exception e){
				System.out.println("连接失败，请检查你的网络连接！");
				System.exit(-1);
			}
			String inputString;
			BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter os = new PrintWriter(client.getOutputStream());
			//由Socket对象得到输入输出流，构造相应的的BufferedReader和PrintWriter对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("对方说：" + is.readLine());
			inputString = sin.readLine();                                //从标准输入读入信息
			while(inputString != null && !inputString.trim().equals("quit chat")){
				os.println(inputString);								 //将信息传至客户端
				os.flush();												 //刷新输出流，使客户端及时得到信息
				System.out.println("我说：" + inputString);
				System.out.println("对方说：" + is.readLine());			 //在屏幕上显示发送和接收的消息
				inputString = sin.readLine();							 //读入新的消息
			}
			os.close();	
			is.close();
			client.close();
			server.close();												 //关闭Socket输入输出流及Socket，ServerSocket
			System.out.println("聊天结束！");
		}catch(Exception e){
			System.out.println("Error:" + e);
		}	
	}
}
