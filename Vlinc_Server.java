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
        // �Ƿ�ɹ����������
        boolean isStart = false;
        // �����socket
        ServerSocket ss = null;
        // �ͻ���socket
        Socket socket = null;

		JFrame frm = new JFrame();
		frm.setTitle("Vlinc���촰��");
		frm.setDefaultCloseOperation(3);
		JButton myBtn = new JButton("����");
		JPanel bottomPanel = new JPanel();
		JPanel topPanel = new JPanel();
		inputField.setEditable(true);										//����ɱ༭
		inputField.setHorizontalAlignment(SwingConstants.LEFT);				//���뿿��
		inputField.setColumns(40);											//��������40�ַ�
		outputArea.setRows(30);												//�����30��
		outputArea.setColumns(50);											//�����50��
		outputArea.setEditable(false);										//����򲻿ɱ༭
		frm.getContentPane().add(topPanel, BorderLayout.CENTER);			//��������
		frm.getContentPane().add(bottomPanel, BorderLayout.SOUTH);			//�����ӵײ�
		topPanel.add(outputArea);
		bottomPanel.add(inputField);
		bottomPanel.add(myBtn);
		frm.setBounds(400, 200, 600, 600);
		inputField.addActionListener(new Alistener());
		frm.setVisible(true);
        try {
            // ����������
            ss = new ServerSocket(6060);
        } catch (BindException e) {
            System.out.println("�˿�����ʹ����");
            // �رճ���
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            isStart = true;
            while (isStart) {
                boolean isConnect = false;
                // ��������
                socket = ss.accept();
                System.out.println("one client connect");
                isConnect = true;
                while (isConnect) {
                    // ��ȡ�ͻ���������
                    dataInputStream = new DataInputStream(
                            socket.getInputStream());
                    // ��ȡ�ͻ��˴��ݵ�����
                    String message = dataInputStream.readUTF();
                    outputArea.append(message + "\n"); 
                }

            }
        } catch (EOFException e) {
            System.out.println("client closed!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ر������Դ
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