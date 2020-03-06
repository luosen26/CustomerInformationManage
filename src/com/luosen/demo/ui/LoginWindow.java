package com.luosen.demo.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luosen.demo.controller.UserService;
import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.domain.Userinfo;
import com.luosen.demo.utils.Tools;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginWindow extends JFrame {
	private Userinfo user;
	private UserinfoDao userinfoDao;
	private UserService userService;
	private JPanel contentPane;
	private JTextField accountNumbertextField;
	private JPasswordField passwordtextField;
	
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}

	public UserService getUserService() {
		return userService;
	}
	public Userinfo getUser() {
		return user;
	}
	
	/**
	 * Create the Loginframe.
	 */
	public LoginWindow(UserinfoDao userinfoDao,UserService userService) {
		this.userinfoDao=userinfoDao;
		this.userService=userService;
		setBackground(SystemColor.scrollbar);
		setFont(new Font("宋体", Font.BOLD, 16));
		setTitle("\u767B\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 327);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		setLocation(Tools.getPostion(519, 400));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setForeground(new Color(0, 206, 209));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u5149\u4E34");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 38));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 206, 209));
		panel_2.setForeground(new Color(0, 206, 209));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel accountNuberlabel = new JLabel("\u8D26\u53F7\uFF1A");
		accountNuberlabel.setFont(new Font("宋体", Font.BOLD, 20));
		accountNuberlabel.setForeground(Color.BLUE);
		accountNuberlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		accountNuberlabel.setBounds(109, 10, 66, 40);
		panel_2.add(accountNuberlabel);
		
		JLabel passwordlabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordlabel.setFont(new Font("宋体", Font.BOLD, 20));
		passwordlabel.setForeground(Color.BLUE);
		passwordlabel.setBounds(109, 53, 66, 40);
		panel_2.add(passwordlabel);
		
		accountNumbertextField = new JTextField();
		accountNumbertextField.setForeground(Color.BLUE);
		accountNumbertextField.setFont(new Font("宋体", Font.BOLD, 20));
		accountNumbertextField.setBackground(Color.WHITE);
		accountNumbertextField.setBounds(178, 17, 166, 27);
		panel_2.add(accountNumbertextField);
		accountNumbertextField.setColumns(10);
		//注册登录功能
		accountNumbertextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					login(userinfoDao, userService);
				}else {
					return;
				}	
			}
		});
		
		passwordtextField = new JPasswordField();
		passwordtextField.setForeground(Color.BLUE);
		passwordtextField.setFont(new Font("宋体", Font.BOLD, 20));
		passwordtextField.setBackground(Color.WHITE);
		passwordtextField.setBounds(178, 60, 166, 27);
		panel_2.add(passwordtextField);
		//注册登录功能
		passwordtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					login(userinfoDao, userService);
				}else {
					return;
				}
			}
		});
		
		JLabel registerlabel = new JLabel("\u6CE8\u518C\u8D26\u53F7");
		registerlabel.setFont(new Font("宋体", Font.BOLD, 16));
		registerlabel.setForeground(Color.WHITE);
		registerlabel.setBounds(354, 12, 80, 40);
		panel_2.add(registerlabel);
		//注册注册功能
		registerlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				register();
			}
		});
		
		
		JLabel forgetPasswordlabel = new JLabel("\u5FD8\u8BB0\u5BC6\u7801\uFF1F");
		forgetPasswordlabel.setForeground(Color.WHITE);
		forgetPasswordlabel.setFont(new Font("宋体", Font.BOLD, 16));
		forgetPasswordlabel.setBounds(354, 53, 90, 40);
		panel_2.add(forgetPasswordlabel);
		//注册忘记密码功能
		forgetPasswordlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				forgetPassword();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 206, 209));
		panel_3.setForeground(new Color(0, 206, 209));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setFont(new Font("宋体", Font.BOLD, 22));
		loginButton.setBackground(Color.CYAN);
		loginButton.setForeground(Color.RED);
		loginButton.setBounds(47, 24, 120, 45);
		panel_3.add(loginButton);
		//注册登录功能
		loginButton.addActionListener(e ->{
			login(userinfoDao, userService);
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.setBackground(Color.CYAN);
		cancelButton.setFont(new Font("宋体", Font.BOLD, 22));
		cancelButton.setForeground(Color.RED);
		cancelButton.setBounds(321, 24, 120, 45);
		panel_3.add(cancelButton);
		//注册取消功能
		cancelButton.addActionListener(e ->{
			System.exit(0);
		});
	}
	
	private void login(UserinfoDao userinfoDao, UserService userService) {
		String accountNumber=accountNumbertextField.getText();
		if (!accountNumber.equals("")) {
			try {
				int account=Integer.parseInt(accountNumber);
				String password=new String(passwordtextField.getPassword());
				if (userService.userLogin(account,password, userinfoDao)) {
					user=userinfoDao.findByUid(Integer.parseInt(accountNumbertextField.getText()));
					JOptionPane.showMessageDialog(null, "欢迎"+user.getU_name()+"登录");
					new ContactWindow(user).setVisible(true);
					dispose();
				}else {
					showMessage();
				}
			} catch (Exception e) {
				showMessage();
			}
		}else {
			showMessage();
		}
	}
	
	private void register() {
		new RegisterWindow(this).setVisible(true);
		setVisible(false);
	}
	private void forgetPassword() {
		new ForgetPasswordWindow(this).setVisible(true);
		setVisible(false);
	}

	private void showMessage() {
		JLabel label = new JLabel("您输入的账号或密码有误，请重新输入。");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		JOptionPane.showMessageDialog(null, label, "登录失败",
		JOptionPane.ERROR_MESSAGE);
	}
}
