import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.swing.*;
 
public class register implements ActionListener {
	JFrame jf;
	JTextField jtf;
	JPasswordField jpf, jpf2;
 
	public register() {
		jf = new JFrame("ע��");
		jf.setLayout(new GridLayout(6, 1));
		jf.add(new JPanel());
		JLabel jl1 = new JLabel(" ��  ��  ����");
		jtf = new JTextField(12);
		JPanel jp1 = new JPanel();
		jp1.add(jl1);
		jp1.add(jtf);
		jf.add(jp1);
 
		JLabel jl2 = new JLabel(" ��        �룺");
		jpf = new JPasswordField(12);
		JPanel jp2 = new JPanel();
		jp2.add(jl2);
		jp2.add(jpf);
		jf.add(jp2);
 
		JLabel jl3 = new JLabel("ȷ�����룺");
		jpf2 = new JPasswordField(12);
		JPanel jp3 = new JPanel();
		jp3.add(jl3);
		jp3.add(jpf2);
		jf.add(jp3);
 
		JPanel jp4 = new JPanel();
		JButton jb1 = new JButton("ȷ��ע��");
		jb1.addActionListener(this);
		JButton jb2 = new JButton("ȡ��");
		jb2.addActionListener(this);
		jp4.add(jb1);
		jp4.add(jb2);
		jf.add(jp4);
 
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(300, 240);
		jf.setLocation(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
 
	public static void main(String[] args) {
		new register();
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		if (comm.equals("ȷ��ע��")) {
			// jf.dispose();
			if ("".equals(jtf.getText())
					|| "".equals(new String(jpf.getPassword()))
					|| jpf.getPassword() == null
					|| "".equals(new String(jpf2.getPassword()))
					|| jpf2.getPassword() == null) {
				final JFrame jf = new JFrame("����");
				JLabel jl = new JLabel("�û��� ���� ���� ����Ϊ�գ�");
				JPanel jp1 = new JPanel();
				JPanel jp2 = new JPanel();
				jp1.add(jl);
				jf.add(jp1);
				JButton jb = new JButton("ȷ��");
				jb.addActionListener(new ActionListener() {
 
					@Override
					public void actionPerformed(ActionEvent e) {
						jf.dispose();
					}
 
				});
				jp2.add(jb);
				jf.add(jp2);
				jf.setLayout(new GridLayout(2, 1));
				jf.setResizable(false);
				jf.setVisible(true);
				jf.pack();
				jf.setLocation(400, 300);
			} else {
				String s = jtf.getText() + "&&" + new String(jpf.getPassword())
						+ "\r\n";
				String name = jtf.getText() + "&&";
				File file = new File("D:\\reg.txt");
				try {
					file.createNewFile(); 
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try { 
					FileInputStream fis = new FileInputStream(file);
					String s1 = "";
					byte[] b = new byte[1024];
					while (true) {
						int i = fis.read(b);
						if (i == -1)
							break;
						s1 = s1 + new String(b, 0, i);
					}
					fis.close();
					int i = s1.indexOf(name);
					if (i == -1) {
						if (new String(jpf.getPassword()).equals(new String(
								jpf2.getPassword()))) {
							try {
								FileOutputStream fos = new FileOutputStream(
										file, true);
					
								fos.write(s.getBytes());
								fos.close();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							int a = JOptionPane.showConfirmDialog(jf, "ע��ɹ���\n"
									+ "�û��� �� " + jtf.getText() + "\n���� �� "
									+ new String(jpf.getPassword())
									+ "\n��ȷ��ת���¼����", "ע����",
									JOptionPane.OK_CANCEL_OPTION);
							if (a == 0) {
								jf.dispose();
								new logon();
							}
						} else {
							JOptionPane.showConfirmDialog(
									jf, 
									"�������벻һ��!\n�������������룡", "���벻һ��",
									JOptionPane.CLOSED_OPTION);
							jpf.setText(null);
							jpf2.setText(null);
							jpf.requestFocus();
						}
					} else {
 
						JOptionPane.showConfirmDialog(
								jf, 
								"�û����Ѿ���ע��!\n�뻻һ���û�������ע�ᣡ", "����",
								JOptionPane.CLOSED_OPTION);
						jtf.setText(null);
						jpf.setText(null);
						jpf2.setText(null);
						jtf.requestFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (comm.equals("ȡ��")) {
			System.exit(0);
		}
 
	}
} 

