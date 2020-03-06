package com.luosen.demo.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luosen.demo.domain.Userinfo;
import com.luosen.demo.utils.Tools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class RegisterWindow extends JFrame {
	private LoginWindow login;
	private JPanel contentPane;
	private String sex;
	private JTextField nametextField;
	private JPasswordField passwordField;
	private JPasswordField yespasswordField;

	/**
	 * Create the frame.
	 */
	public RegisterWindow(LoginWindow login) {
		setResizable(false);
		this.login=login;
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocation(Tools.getPostion(406, 576));
		
		JLabel welcomLabel = new JLabel("\u6B22\u8FCE\u6CE8\u518C");
		welcomLabel.setBounds(10, 10, 382, 154);
		welcomLabel.setFont(new Font("宋体", Font.BOLD, 65));
		welcomLabel.setForeground(Color.BLUE);
		welcomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel namelabel = new JLabel("\u59D3\u540D\uFF1A");
		namelabel.setFont(new Font("宋体", Font.BOLD, 20));
		namelabel.setBounds(27, 187, 66, 40);
		
		JLabel passwordlabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlabel.setFont(new Font("宋体", Font.BOLD, 20));
		passwordlabel.setBounds(27, 310, 66, 40);
		
		JLabel yespasswoedlabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		yespasswoedlabel.setFont(new Font("宋体", Font.BOLD, 20));
		yespasswoedlabel.setBounds(10, 370, 105, 40);
		
		JRadioButton manradioButton = new JRadioButton("\u7537");
		manradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		manradioButton.setSelected(true);
		sex=manradioButton.getText();
		manradioButton.addActionListener(e ->{
			sex=manradioButton.getText();
		});
		manradioButton.setBounds(136, 258, 53, 23);
		
		JLabel sexlabel = new JLabel("\u6027\u522B\uFF1A");
		sexlabel.setFont(new Font("宋体", Font.BOLD, 20));
		sexlabel.setBounds(27, 248, 66, 40);
		
		JRadioButton girlradioButton = new JRadioButton("\u5973");
		girlradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		girlradioButton.addActionListener(e ->{
			sex=girlradioButton.getText();
		});
		girlradioButton.setBounds(218, 257, 58, 23);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(manradioButton);
		bg.add(girlradioButton);
		
		nametextField = new JTextField();
		nametextField.setFont(new Font("宋体", Font.BOLD, 20));
		nametextField.setBounds(125, 187, 166, 30);
		nametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.BOLD, 20));
		passwordField.setBounds(125, 306, 166, 30);
		
		yespasswordField = new JPasswordField();
		yespasswordField.setFont(new Font("宋体", Font.BOLD, 20));
		yespasswordField.setBounds(125, 368, 166, 30);
		contentPane.setLayout(null);
		contentPane.add(welcomLabel);
		contentPane.add(namelabel);
		contentPane.add(passwordlabel);
		contentPane.add(yespasswoedlabel);
		contentPane.add(manradioButton);
		contentPane.add(sexlabel);
		contentPane.add(girlradioButton);
		contentPane.add(nametextField);
		contentPane.add(passwordField);
		contentPane.add(yespasswordField);
		
		JButton registerbutton = new JButton("\u6CE8\u518C");
		registerbutton.setFont(new Font("宋体", Font.BOLD, 22));
		registerbutton.setBounds(30, 460, 120, 45);
		contentPane.add(registerbutton);
		//注册用户注册功能
		registerbutton.addActionListener(e ->{
			register(login);
		});
		
		JButton returnbutton = new JButton("\u8FD4\u56DE");
		returnbutton.setFont(new Font("宋体", Font.BOLD, 22));
		returnbutton.setBounds(227, 460, 120, 45);
		contentPane.add(returnbutton);
		//注册返回功能
		returnbutton.addActionListener(e ->{
			login.setVisible(true);
			dispose();
		});
	}

	private void register(LoginWindow login) {
		String name=Tools.isNumerOfName(nametextField.getText());
		Userinfo u=login.getUserinfoDao().findByUname(name);
		if (u!=null) {
			JOptionPane.showMessageDialog(null, "注册失败，你已经注册过了，快去登录吧！");
			login.setVisible(true);
			dispose();
			return;
		}else {
			if (name==null) {
				JOptionPane.showMessageDialog(null, "注册失败，你输入的名字中含有数字");
				return;
			}else {
				String password=new String(passwordField.getPassword());
				String yesPassword=new String(yespasswordField.getPassword());
				if (!password.equals("")) {
					if (password.equals(yesPassword)) {
						Userinfo userinfo=new Userinfo(name,password,"",sex,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
						if (login.getUserService().userRegister(userinfo, login.getUserinfoDao())) {
							userinfo=login.getUserinfoDao().findByUname(name);
							JOptionPane.showMessageDialog(null, "注册成功,你的账号为："+userinfo.getU_id());
							login.setVisible(true);
							dispose();
							return;
						}
					}else {
						JOptionPane.showMessageDialog(null, "注册失败，你输入的密码和确认密码不一致");
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null, "注册失败，密码不能为空！！！");
					return;
				}
			}
		}
	}
}
