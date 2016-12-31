package Vlinc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

//import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import Vlinc.Vlinc_Server.Alistener;

public class Vlinc_Server {

    static DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
	static JTextField inputField = new JTextField();
	static JTextArea outputArea = new JTextArea();
    public static void main(String[] args) {
    	new Vlinc_Server().launch();
    }
    public void launch(){
        // 是否成功启动服务端
        boolean isStart = false;
        // 服务端socket
        ServerSocket ss = null;
        // 客户端socket
        Socket socket = null;

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
        try {
            // 启动服务器
            ss = new ServerSocket(6060);
        } catch (BindException e) {
            System.out.println("端口已在使用中");
            // 关闭程序
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            isStart = true;
            while (isStart) {
                boolean isConnect = false;
                // 启动监听
                socket = ss.accept();
                System.out.println("one client connect");
                isConnect = true;
                while (isConnect) {
                    // 获取客户端输入流
                    dataInputStream = new DataInputStream(
                            socket.getInputStream());
                    // 读取客户端传递的数据
                    String message = dataInputStream.readUTF();
                    outputArea.append(message + "\n"); 
                }

            }
        } catch (EOFException e) {
            System.out.println("client closed!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭相关资源
            try {
                dataInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    public void sendMessage(String str){
		try{
			dataOutputStream.writeUTF(str);
			dataOutputStream.flush();
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
}