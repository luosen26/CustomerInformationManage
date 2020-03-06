package com.luosen.demo.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.dao.impl.UserinfoDaoImpl;
import com.luosen.demo.utils.Tools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ModifyUserinfoWindow extends JFrame {
	private UserinfoDao userinfoDao;
	private JPanel contentPane;
	private String sex;
	private JTextField nametextField;

	/**
	 * Create the frame.
	 */
	public ModifyUserinfoWindow(ContactWindow contact) {
		userinfoDao = new UserinfoDaoImpl();
		sex = "男";
		setResizable(false);
		setTitle("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocation(Tools.getPostion(405, 589));

		JLabel welcomLabel = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		welcomLabel.setBounds(10, 10, 382, 154);
		welcomLabel.setFont(new Font("宋体", Font.BOLD, 60));
		welcomLabel.setForeground(Color.BLUE);
		welcomLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel namelabel = new JLabel("\u59D3\u540D\uFF1A");
		namelabel.setFont(new Font("宋体", Font.BOLD, 20));
		namelabel.setBounds(27, 187, 66, 40);

		JRadioButton manradioButton = new JRadioButton("\u7537");
		manradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		manradioButton.addActionListener(e -> {
			sex = manradioButton.getText();
		});
		manradioButton.setBounds(87, 271, 53, 23);

		JLabel sexlabel = new JLabel("\u6027\u522B\uFF1A");
		sexlabel.setFont(new Font("宋体", Font.BOLD, 20));
		sexlabel.setBounds(27, 262, 66, 40);

		JRadioButton girlradioButton = new JRadioButton("\u5973");
		girlradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		girlradioButton.addActionListener(e -> {
			sex = girlradioButton.getText();
		});
		girlradioButton.setBounds(184, 271, 58, 23);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manradioButton);
		bg.add(girlradioButton);
		if (contact.getUser().getU_sex().equals("男")) {
			manradioButton.setSelected(true);
		} else {
			girlradioButton.setSelected(true);
		}

		nametextField = new JTextField(contact.getUser().getU_name());
		nametextField.setFont(new Font("宋体", Font.BOLD, 20));
		nametextField.setBounds(87, 192, 260, 30);
		nametextField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(welcomLabel);
		contentPane.add(namelabel);
		contentPane.add(manradioButton);
		contentPane.add(sexlabel);
		contentPane.add(girlradioButton);
		contentPane.add(nametextField);

		JLabel label = new JLabel("\u5730\u5740\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(27, 324, 66, 40);
		contentPane.add(label);

		JTextArea addrtextArea = new JTextArea(contact.getUser().getU_addr());
		addrtextArea.setLineWrap(true);
		addrtextArea.setRows(10);
		addrtextArea.setWrapStyleWord(true);
		addrtextArea.setToolTipText("");
		addrtextArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		addrtextArea.setBounds(87, 334, 278, 120);
		contentPane.add(addrtextArea);

		JButton modifybutton = new JButton("\u4FEE\u6539");
		modifybutton.setFont(new Font("宋体", Font.BOLD, 22));
		modifybutton.setBounds(27, 480, 120, 45);
		contentPane.add(modifybutton);
		// 注册修改用户信息功能
		modifybutton.addActionListener(e -> {
			modify(contact, addrtextArea);
		});

		JButton returnbutton = new JButton("\u8FD4\u56DE");
		returnbutton.setFont(new Font("宋体", Font.BOLD, 22));
		returnbutton.setBounds(227, 480, 120, 45);
		contentPane.add(returnbutton);
		// 注册返回功能
		returnbutton.addActionListener(e -> {
			contact.setVisible(true);
			dispose();
		});

	}

	private void modify(ContactWindow contact, JTextArea addrtextArea) {
		String name = nametextField.getText();
		if (!name.equals("")) {
			name = Tools.isNumerOfName(name);
			if (name != null) {
				if (contact.getUser().getU_name().equals(name)) {
					modify(contact, addrtextArea, name);
				} else {
					if (userinfoDao.findByUname(name) == null) {
						contact.getUser().setU_name(name);
						modify(contact, addrtextArea, name);
					} else {
						JOptionPane.showMessageDialog(null, "修改失败，该用户姓名已存在");
						return;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "姓名中不能含有数字");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
	}

	private void modify(ContactWindow contact, JTextArea addrtextArea, String name) {
		contact.getUser().setU_sex(sex);
		contact.getUser().setU_addr(addrtextArea.getText());
		boolean flag = contact.getUserService().modifyUserinfo(contact.getUser(), userinfoDao);
		if (flag) {
			JOptionPane.showMessageDialog(null, "用户信息修改成功");
			contact.getUserlabel().setText(name);
			contact.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "用户信息修改失败");
			return;
		}
	}
}
