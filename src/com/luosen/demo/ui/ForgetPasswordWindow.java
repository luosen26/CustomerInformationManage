package com.luosen.demo.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luosen.demo.domain.Userinfo;
import com.luosen.demo.utils.Tools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ForgetPasswordWindow extends JFrame {
	private JPanel contentPane;
	private Userinfo user;
	private String sex;
	private JTextField nameField;
	private JTextField IDField;
	private JTextField newpasswordField;

	/**
	 * Create the frame.
	 */
	public ForgetPasswordWindow(LoginWindow login) {
		setResizable(false);
		this.user = login.getUser();
		setTitle("\u627E\u56DE\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(Tools.getPostion(424, 601));

		JLabel lblNewLabel = new JLabel("\u627E\u56DE\u5BC6\u7801");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 65));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 382, 150);
		contentPane.add(lblNewLabel);

		JLabel namelabel = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		namelabel.setFont(new Font("宋体", Font.BOLD, 20));
		namelabel.setBounds(20, 182, 105, 40);
		contentPane.add(namelabel);

		JLabel IDLable = new JLabel("\u7528\u6237ID:");
		IDLable.setFont(new Font("宋体", Font.BOLD, 20));
		IDLable.setBounds(34, 265, 91, 40);
		contentPane.add(IDLable);

		JLabel sexlabel = new JLabel("\u7528\u6237\u6027\u522B\uFF1A");
		sexlabel.setFont(new Font("宋体", Font.BOLD, 20));
		sexlabel.setBounds(20, 339, 105, 40);
		contentPane.add(sexlabel);

		JLabel newpasswordlabel = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		newpasswordlabel.setFont(new Font("宋体", Font.BOLD, 20));
		newpasswordlabel.setBounds(34, 404, 91, 40);
		contentPane.add(newpasswordlabel);

		JButton yesButton = new JButton("\u786E\u5B9A");
		yesButton.setFont(new Font("宋体", Font.BOLD, 22));
		yesButton.addActionListener(e -> {
			String name = nameField.getText();
			if (!name.equals("")) {
				user = login.getUserinfoDao().findByUname(name);
				if (user != null) {
					String id = IDField.getText();
					if (id.equals("" + user.getU_id())) {
						if (sex.equals(user.getU_sex())) {
							String password = newpasswordField.getText();
							if (!password.equals("")) {
								user.setU_password(password);
								boolean flag = login.getUserService().modifyUserPassword(user.getU_password(),
										user.getU_id(), login.getUserinfoDao());
								if (flag) {
									JOptionPane.showMessageDialog(null, "密码修改成功，快去登陆吧！！！");
									login.setVisible(true);
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "密码修改失败");
									return;
								}
							} else {
								JOptionPane.showMessageDialog(null, "密码不能为空");
								return;
							}
						} else {
							JOptionPane.showMessageDialog(null, "用户性别错误");
							return;
						}
					} else {
						JOptionPane.showMessageDialog(null, "用户ID错误");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "用户名不存在");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
		});
		yesButton.setBounds(40, 485, 120, 45);
		contentPane.add(yesButton);

		JButton returnbutton = new JButton("\u8FD4\u56DE");
		returnbutton.setFont(new Font("宋体", Font.BOLD, 22));
		returnbutton.addActionListener(e -> {
			login.setVisible(true);
			dispose();
		});
		returnbutton.setBounds(245, 485, 120, 45);
		contentPane.add(returnbutton);

		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.BOLD, 20));
		nameField.setBounds(130, 187, 166, 30);
		contentPane.add(nameField);
		nameField.setColumns(10);

		IDField = new JTextField();
		IDField.setFont(new Font("宋体", Font.BOLD, 20));
		IDField.setColumns(10);
		IDField.setBounds(130, 270, 166, 30);
		contentPane.add(IDField);

		newpasswordField = new JTextField();
		newpasswordField.setFont(new Font("宋体", Font.BOLD, 20));
		newpasswordField.setColumns(10);
		newpasswordField.setBounds(130, 409, 166, 30);
		contentPane.add(newpasswordField);

		JRadioButton manradioButton = new JRadioButton("\u7537");
		manradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		manradioButton.addActionListener(e -> {
			sex = manradioButton.getText();
		});
		manradioButton.setBounds(130, 350, 53, 23);
		contentPane.add(manradioButton);
		manradioButton.setSelected(true);

		JRadioButton girlradioButton = new JRadioButton("\u5973");
		girlradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		girlradioButton.addActionListener(e -> {
			sex = girlradioButton.getText();
		});
		girlradioButton.setBounds(222, 350, 53, 23);
		contentPane.add(girlradioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manradioButton);
		bg.add(girlradioButton);
	}
}
