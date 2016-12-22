import java.awt.*; 
import javax.swing.*;  
//import javax.swing.border.Border; 
//import javax.swing.border.EtchedBorder; 
//import javax.swing.border.TitledBorder; 
import java.awt.event.*;  
public class UserTest4 extends JFrame implements ActionListener,ItemListener { 
	private static final long serialVersionUID = -844691391786953859L;  
	public JLabel jl1,jl2,jl3,jl4,jl5,jl6; 
	public JTextField jt=null;  
	public JRadioButton jr1,jr2; 
	public ButtonGroup bg;  
	public 
	String str1[]={"2000年","1999年","1998年","1997年","1996年",
			"1995年","1994年","1993年","1992年","1991年",
			"1990年","1989年","1988年","1987年","1986年",
			"1985年","1984年","1983年","1982年","1981年",
			"1980年","1979年","1978年","1977年","1976年",
			"1975年","1974年","1973年","1972年","1971年","1970年"};  
	public String str2[]={"12月","11月","10月"," 9 月"," 8 月",
			" 7 月"," 6 月"," 5 月"," 4 月"," 3 月"," 2 月"," 1 月"};  
	public String str3[]={" 31日"," 30日"," 29日"," 28日"," 27日"," 26日"," 25日"," 24日"," 23日",
			" 22日"," 21日"," 20日"," 19日"," 18日"," 17日"," 16日"," 15日"," 14日"," 13日"," 12日",
			" 11日"," 10日"," 09日"," 08日"," 07日"," 06日"," 05日"," 04日"," 03日"," 02日"," 01日",};   
    public String str4[]={"电影","阅读","网络","编程","艺术","游戏","其他","旅游"}; 
    public String str5[]={"北京","上海","","","","","","",""} ;
	public JTextArea ja; 
	public JButton jb1,jb2; 
	public JComboBox jc1,jc2,jc3; 
	public String st1,st2,st3,st4,st5;  
	public JCheckBox jh[]=new JCheckBox[8]; 
	public static void main(String[] args) { 
	new UserTest4();
	} 
	public UserTest4() { 
	this.getContentPane().setLayout(new FlowLayout()); 
	jl1=new JLabel("请输入你的个人资料，完成后单击确定"); 
			jl2=new JLabel("昵称:"); 
			jt=new JTextField(7); 
			jl3=new JLabel("性别:");  
			jr1=new JRadioButton("男",true); 
			jr2=new JRadioButton("女"); 
			bg=new ButtonGroup(); 
			jl4=new JLabel("生日:"); 
			jc1=new JComboBox(str1);
			jc1.addItemListener(this);
			jc2=new JComboBox(str2); 
			jc2.addItemListener(this); 
			jc3=new JComboBox(str3); 
			jc3.addItemListener(this); 
			bg.add(jr1);  
			bg.add(jr2);  
			jl5=new JLabel("爱好:"); 
			jl6=new JLabel("个性签名："); 
			ja=new JTextArea(5,22); 
			jb1=new JButton("确定"); 
			jb1.setBounds(10, 60, 20, 10); 
			jb1.addActionListener(this); 
			jb2=new JButton("退出"); 
			jb2.addActionListener(this); 
			this.getContentPane().add(jl1); 
			this.getContentPane().add(jl2); 
			this.getContentPane().add(jt); 
			this.getContentPane().add(jl3); 
			this.getContentPane().add(jr1); 
			this.getContentPane().add(jr2); 
			this.getContentPane().add(jl4); 
			this.getContentPane().add(jc1); 
			this.getContentPane().add(jc2); 
			this.getContentPane().add(jc3); 
			this.getContentPane().add(jl5); 
			for(int i=0;i<str4.length;i++) {  
			jh[i]=new JCheckBox(str4[i]);  
			jh[i].addActionListener(this); 
			this.getContentPane().add(jh[i]); 
			}  
			this.getContentPane().add(jl6); 
			this.getContentPane().add(ja); 
			this.getContentPane().add(jb1); 
			this.getContentPane().add(jb2); 
			jt.setBackground(Color.YELLOW); 
			ja.setBackground(Color.YELLOW); 
			this.setBounds(290, 30, 280,360); 
			this.setResizable(false); 
			this.setVisible(true); 
			}  
			public void actionPerformed(ActionEvent e) {  
			String ss=e.getActionCommand();  
			if(ss.equals("确定")) { 
			if(jr1.isSelected()) { 
			st1="男"; 
			}  
		if(jr2.isSelected()) {
			st1="女"; 
			}  
			ja.setText(" 昵称:"+jt.getText()+"\n"+" 性别："+st1+"\n"+" 生日 ："+st2+st3+st4+"\n"+" 爱好："); 
			for(int i=0;i<str4.length;i++)
		{  
		   if(jh[i].isSelected()) 
			{ 
			st5=str4[i]; 
			ja.append(st5);  	 
			}	 
			} 
			}  	 
		if(ss.equals("退出")) 
			{ 
			System.exit(0); 
			}	 
	}  
	
	@Override  
	 
	public void itemStateChanged(ItemEvent ex) { 
	// TODO Auto-generated method stub 
	if(ex.getItemSelectable()==jc1) 
	
	{ 
 
	st2=(String)(jc1.getSelectedItem());  
	
	}  

	if(ex.getItemSelectable()==jc2) 	 
	{	 
	st3=(String)(jc2.getSelectedItem());  
	} 	 
	if(ex.getItemSelectable()==jc3) 	 
	{ 	  
	st4=(String)(jc3.getSelectedItem());  
	 
	} 

	}  
	
	}
