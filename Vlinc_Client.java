package Vlinc;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vlinc_Client {
	DataOutputStream dataOutputStream = null;
	static DataInputStream dataInputStream = null;
	JTextField inputField = new JTextField();
	static JTextArea outputArea = new JTextArea();
	static Socket socket = null;
	static boolean isStart;
	static boolean isConnect;
	public String str1;
	public static void main(String[] args){
		new Vlinc_Client().launch();
		try{
			isStart = true;
			while(isStart){
				isConnect = false;
				isConnect = socket.isConnected();
				while(isConnect){
					dataInputStream = new DataInputStream(socket.getInputStream());
					String str1 = dataInputStream.readUTF();
					outputArea.append(str1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dataInputStream.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
}
	public void launch(){
		JFrame frm = new JFrame();
		frm.setTitle("Vlinc聊天窗口");
		frm.setDefaultCloseOperation(3);
		JButton myBtn = new JButton("发送");
		JPanel bottomPanel = new JPanel();
		JPanel topPanel = new JPanel();
		inputField.setEditable(true);										//输入可编辑
		inputField.setHorizontalAlignment(SwingConstants.LEFT);				//输入靠左
		inputField.setColumns(40);											//输入框最多40字符
		outputArea.setRows(30);												//输出框30行
		outputArea.setColumns(50);											//输出框50列
		outputArea.setEditable(false);										//输出框不可编辑
		frm.getContentPane().add(topPanel, BorderLayout.CENTER);			//输出框居中
		frm.getContentPane().add(bottomPanel, BorderLayout.SOUTH);			//输入框居底部
		topPanel.add(outputArea);
		bottomPanel.add(inputField);
		bottomPanel.add(myBtn);
		frm.setBounds(400, 200, 600, 600);
		inputField.addActionListener(new Alistener());
		frm.setVisible(true);
		connect();
	}
	public void connect(){
		try{
			socket = new Socket("127.0.0.1",6060);
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void disConnect(){
		try{
			dataOutputStream.close();
			socket.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void sendMessage(String str){
		try{
			dataOutputStream.writeUTF(str);
			dataOutputStream.flush();
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}

	public class Alistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String str = inputField.getText().trim();
			outputArea.append(str + "\n");
			inputField.setText("");
			sendMessage(str);
		}
	}
}