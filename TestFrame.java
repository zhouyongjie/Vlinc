package coolbaby6;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class TestFrame {

 private JFrame jFrame = null; 

 private JPanel jContentPane = null;
 
 private JScrollPane scrollPane=null;

 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    TestFrame application = new TestFrame();
    application.getJFrame().setVisible(true);
   }
  });
 }

 private JFrame getJFrame() {
  if (jFrame == null) {
   jFrame = new JFrame();
   jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   jFrame.setSize(230, 700);
   jFrame.setTitle("ģ��ʵ��QQ��幦��");
   jFrame.setContentPane(getJContentPane());
  }
  return jFrame;
 }
 
 
 private JScrollPane getScrollPane(){//����Ӻ��ѵ�����JPanel��ӹ�������
  if(scrollPane==null){
   scrollPane=new JScrollPane(new TestPane());
   //scrollPane.setBounds(20,5, -1, 600);
   scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );//����ʾˮƽ��������
  }
  return scrollPane;
 }

 
 private JPanel getJContentPane() {//ʵ�����ײ������JPanel��
  if (jContentPane == null) {
   jContentPane = new JPanel();
   jContentPane.setLayout(new BorderLayout());
   jContentPane.add(getScrollPane(), BorderLayout.CENTER);
  }
  return jContentPane;
 }
}

