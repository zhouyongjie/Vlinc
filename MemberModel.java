package coolbaby6;

import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

public class MemberModel{

 private static final long serialVersionUID = 1L;

 public JButton jButton = null;//��ʾ����ͷ��

 public JPanel jPanel = new JPanel();//ģ��������

 private JLabel lb_nickName = null;//��ʾ�ǳƣ�

 private int pic;

 private String nickname = null;

 private JLabel lb_mood = null;//��ʾ���飻

 
 public MemberModel(int pic, String nickname, int len) {
  super();
  this.pic = pic;//ͷ��ࣨ�ж��ַ�������ʵ�֣�������򵥣�
  this.nickname = nickname;//�ǳƣ�
  initialize();
 }

 
 private void initialize() {
  lb_mood = new JLabel();
  lb_mood.setBounds(new Rectangle(51, 30, 131, 20));
  lb_mood.setFont(new Font("Dialog", Font.PLAIN, 12));
  lb_mood.setText("��������ңԶ�ľ��벻��������,������վ������ǰ��ȴ��֪���Ұ���!");
  lb_mood.addMouseListener(new java.awt.event.MouseAdapter() {
   public void mouseEntered(java.awt.event.MouseEvent e) {
    exchangeEnter();
    lb_mood.setToolTipText(lb_mood.getText());
   }
   public void mouseExited(java.awt.event.MouseEvent e) {
    exchangeExited();
   }

  });
  lb_nickName = new JLabel();
  lb_nickName.setBounds(new Rectangle(52, 10, 80, 20));
  lb_nickName.setFont(new Font("Dialog", Font.BOLD, 14));
  lb_nickName.setText(nickname);
  jPanel.setSize(new Dimension(185, 60));
  jPanel.setLayout(null);
  jPanel.add(getJButton(), null);
  jPanel.add(lb_nickName, null);
  jPanel.add(lb_mood, null);
  jPanel.addMouseListener(new java.awt.event.MouseAdapter() {  
   public void mouseExited(java.awt.event.MouseEvent e) {
    exchangeExited();//����Ƴ�ģ�������ı䱳����ɫ��
   }

   public void mouseEntered(java.awt.event.MouseEvent e) {
    exchangeEnter();//����ƽ�ģ�������ı䱳����ɫ��
   }
  });
 }

 private void exchangeEnter() {
  jPanel.setBackground(new Color(192,224,248));
 }

 private void exchangeExited() {
  jPanel.setBackground(null);
 }

 
 private JButton getJButton() {
  if (jButton == null) {
   jButton = new JButton();
   jButton.setBounds(new Rectangle(8, 10, 40, 40));
   jButton.setBackground(new Color(236, 255, 236));
   jButton.setIcon(new ImageIcon(pic + ".jpg"));
   jButton.addMouseListener(new java.awt.event.MouseAdapter() {  
    public void mouseExited(java.awt.event.MouseEvent e) {   
     exchangeExited();//����Ƴ�ģ�������ı䱳����ɫ��
    }  
    public void mouseEntered(java.awt.event.MouseEvent e) {   
     exchangeEnter();//����ƽ�ģ�������ı䱳����ɫ��
    }
   });
  
  }
  return jButton;
 }
}

