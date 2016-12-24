import java.io.*;
import java.net.*;

public class Vlinc_Client {
	public static void main(String[] args){
		Socket server = null;
		try{
			String inputString;
			server = new Socket("127.0.0.1",6060);
			System.out.println("请输入：");
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(server.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(server.getInputStream()));
			inputString = sin.readLine();
			while(inputString != null && !inputString.trim().endsWith("quit chat")){
				os.println(inputString);
				os.flush();
				System.out.println("我说：" + inputString);
				System.out.println("对方说" + is.readLine());
				inputString = sin.readLine();
			}
			os.close();
			is.close();
			server.close();
			System.out.println("聊天结束！");
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace(); 
		}
	}
}
