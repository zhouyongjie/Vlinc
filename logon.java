
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;

public class logon implements ActionListener {
	JFrame jf;
	JTextField jtf;
	JPasswordField jpf;
 
	public logon() {
		jf = new JFrame("��¼");
		jf.setLayout(new GridLayout(5, 1));
		jf.add(new JPanel());
		JLabel jl1 = new JLabel("�û�����");
		jtf = new JTextField(12);
		JPanel jp1 = new JPanel();
		jp1.add(jl1);
		jp1.add(jtf);
		jf.add(jp1);
 
		JLabel jl2 = new JLabel("  ��  �룺 ");
		jpf = new JPasswordField(12);
		JPanel jp2 = new JPanel();
		jp2.add(jl2);
		jp2.add(jpf);
		jf.add(jp2);
 
		JPanel jp3 = new JPanel();
		JButton jb1 = new JButton("��Ҫע��");
		jb1.addActionListener(this);
		JButton jb2 = new JButton("��¼");
		jb2.addActionListener(this);
		JButton jb3 = new JButton("ȡ��");
		jb3.addActionListener(this);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jf.add(jp3);
 
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(300, 200);
		jf.setLocation(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
 
	public static void main(String[] args) {
		new logon();
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		if (comm.equals("��Ҫע��")) { 
			jf.dispose();
			new register();
		} else if (comm.equals("��¼")) {
			if ("".equals(jtf.getText())
					|| "".equals(new String(jpf.getPassword()))
					|| jpf.getPassword() == null) {
				JOptionPane.showConfirmDialog(
						jf, 
						"�û��� ���� ���� ����Ϊ�գ�!\n���������룡", "����",
						JOptionPane.DEFAULT_OPTION);
				jtf.setText(null);
				jpf.setText(null);
				jtf.requestFocus();
			} else {
				String s = jtf.getText() + "&&" + new String(jpf.getPassword());
				String name = jtf.getText() + "&&";
				File file = new File("D:\\reg.txt");
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
					int j = s1.indexOf(s);
					if (i == -1) { 
						JOptionPane.showConfirmDialog(
								jf,
								"û�д��û���!\n������ ��¼ ���� ע�ᣡ", "����",
								JOptionPane.ERROR_MESSAGE);
						jtf.setText(null);
						jpf.setText(null);
						jtf.requestFocus();
					} else {
						if (j == -1) {
							JOptionPane.showConfirmDialog(
									jf, 
									"�������!\n�������������룡", "����",
									JOptionPane.DEFAULT_OPTION);
							jpf.setText(null);
							jpf.requestFocus();
						} else {
							JOptionPane.showConfirmDialog(
									jf, 
									"��¼�ɹ���\n" + "�û��� �� " + jtf.getText()
											+ "\n���� �� "
											+ new String(jpf.getPassword()),
									"��¼���", JOptionPane.DEFAULT_OPTION);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (comm.equals("ȡ��")) {
			System.exit(0);
		}
 
	}
 
} 
