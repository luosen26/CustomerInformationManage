package com.luosen.demo.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luosen.demo.controller.UserService;
import com.luosen.demo.dao.PhoneDao;
import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.dao.impl.UserinfoDaoImpl;
import com.luosen.demo.domain.Userinfo;
import com.luosen.demo.utils.Tools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ModifyPasswordWindow extends JFrame {
	private JPanel contentPane;
	private JTextField odlpasswordField;
	private JPasswordField passwordField;
	private JPasswordField yespasswordField;

	/**
	 * Create the frame.
	 */
	public ModifyPasswordWindow(ContactWindow contact) {
		setResizable(false);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(Tools.getPostion(324, 470));
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 60));
		lblNewLabel.setBounds(20, 10, 289, 92);
		contentPane.add(lblNewLabel);
		
		JLabel odlpasswordLabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		odlpasswordLabel.setFont(new Font("宋体", Font.BOLD, 20));
		odlpasswordLabel.setBounds(35, 138, 90, 40);
		contentPane.add(odlpasswordLabel);
		
		JLabel newpasswordLabel = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		newpasswordLabel.setFont(new Font("宋体", Font.BOLD, 20));
		newpasswordLabel.setBounds(35, 209, 90, 40);
		contentPane.add(newpasswordLabel);
		
		JLabel yespasswordLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		yespasswordLabel.setFont(new Font("宋体", Font.BOLD, 20));
		yespasswordLabel.setBounds(20, 281, 105, 40);
		contentPane.add(yespasswordLabel);
		
		JButton yesButton = new JButton("\u786E\u5B9A");
		yesButton.setFont(new Font("宋体", Font.BOLD, 22));
		yesButton.setBounds(22, 354, 120, 45);
		contentPane.add(yesButton);
		//注册修改密码功能
		yesButton.addActionListener(e ->{
			modify(contact);
		});
		
		JButton returnButton = new JButton("\u8FD4\u56DE");
		returnButton.setFont(new Font("宋体", Font.BOLD, 22));
		returnButton.setBounds(189, 354, 120, 45);
		contentPane.add(returnButton);
		//注册返回功能
		returnButton.addActionListener(e ->{
			contact.setVisible(true);
			dispose();
		});
		
		odlpasswordField = new JTextField();
		odlpasswordField.setFont(new Font("宋体", Font.BOLD, 20));
		odlpasswordField.setBounds(121, 143, 166, 30);
		contentPane.add(odlpasswordField);
		odlpasswordField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.BOLD, 20));
		passwordField.setBounds(121, 214, 166, 30);
		contentPane.add(passwordField);
		
		yespasswordField = new JPasswordField();
		yespasswordField.setFont(new Font("宋体", Font.PLAIN, 20));
		yespasswordField.setBounds(121, 286, 166, 30);
		contentPane.add(yespasswordField);
	}

	private void modify(ContactWindow contact) {
		String odlPassword=odlpasswordField.getText();
		if (odlPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "旧密码不能为空");
			return;
		}else {
			String odlPasswordU=contact.getUser().getU_password();
			if (odlPassword.equals(odlPasswordU)) {
				String newPassword=new String(passwordField.getPassword());
				if (newPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "新密码不能为空");
					return;
				}else {
					String yesNewPassword=new String(yespasswordField.getPassword());
					if (newPassword.equals(yesNewPassword)) {
						contact.getUser().setU_password(newPassword);
						boolean flag=contact.getUserService().modifyUserPassword(contact.getUser().getU_password(),
								contact.getUser().getU_id(), new UserinfoDaoImpl());
						if (flag) {
							JOptionPane.showMessageDialog(null, "密码修改成功");
							contact.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "密码修改失败");
							return;
						}
					}else {
						JOptionPane.showMessageDialog(null, "新密码和确认密码不一致");
						return;
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "你输入的旧密码不正确");
			}
		}
	}
}
