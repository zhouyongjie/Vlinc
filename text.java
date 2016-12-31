
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
public class text extends JFrame{
    JLabel jlb1 = new JLabel(new ImageIcon("QQ.jpg"));
    
    JLabel jlb2 = new JLabel("<html><a href='www.qq.com'>×¢²áÕËºÅ</a>",JLabel.CENTER);
    
    JLabel jlb3 = new JLabel("<html><a href='http://www.qq.com'>ÕÒ»ØÃÜÂë</a>",JLabel.CENTER);
    JLabel jlb4 = new JLabel(new ImageIcon("QQ.jpg"));
    JButton jb1 = new JButton("µÇÂ¼");
    JTextField jtf = new JTextField(10);
    JPasswordField jpf = new JPasswordField(10);
    JCheckBox jcb1 = new JCheckBox("¼Ç×¡ÃÜÂë");
    
    JCheckBox jcb2 = new JCheckBox("×Ô¶¯µÇÂ½");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    public text(){
        
        jp1.add(jtf);
        jp1.add(jlb2);
        jp1.add(jpf);
        jp1.add(jlb3);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp3.add(jp2);
        jp3.add(jlb4);
        
        jlb4.add(jp2,BorderLayout.WEST);
        jp3.add(jp1,BorderLayout.CENTER);
        jp1.setLayout(new GridLayout(3, 3));
        this.add(jb1,BorderLayout.SOUTH);
        this.add(jp3,BorderLayout.CENTER);
        this.add(jlb1,BorderLayout.NORTH);
        ImageIcon icon = new ImageIcon("QQ.jpg");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Welcome To Vlinc");
    }
    public static void main(String[] args){
        new text();
    }
}