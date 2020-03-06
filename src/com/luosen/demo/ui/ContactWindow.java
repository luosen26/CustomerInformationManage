package com.luosen.demo.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.luosen.demo.controller.UserService;
import com.luosen.demo.controller.impl.UserServiceImpl;
import com.luosen.demo.dao.PhoneDao;
import com.luosen.demo.dao.impl.PhoneDaoImpl;
import com.luosen.demo.domain.Phone;
import com.luosen.demo.domain.Userinfo;
import com.luosen.demo.utils.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class ContactWindow extends JFrame {
	private Userinfo user;
	private UserService userService;
	private PhoneDao phoneDao;
	private List<Phone> data = null;
	private String sex;
	private JLabel userlabel;
	private JPanel contentPane;
	private JTable table;
	private TableModel model;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField addrField;
	private JTextField sginField;
	private JRadioButton manradioButton;
	private JRadioButton girlradioButton;
	private int selectedRow = -1;

	public Userinfo getUser() {
		return user;
	}

	public JLabel getUserlabel() {
		return userlabel;
	}

	public UserService getUserService() {
		return userService;
	}

	/**
	 * Create the Contactframe.
	 */
	public ContactWindow(Userinfo user) {
		setResizable(false);
		this.user = user;
		sex = "男";
		setTitle("\u901A\u8BAF\u5F55");
		userService = new UserServiceImpl();
		phoneDao = new PhoneDaoImpl();
		data = userService.findContact(user.getU_id(), 0, null, phoneDao);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 713);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(Tools.getPostion(1038, 713));

		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		userNameLabel.setForeground(Color.BLUE);
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 20));
		userNameLabel.setBounds(10, 10, 85, 40);
		contentPane.add(userNameLabel);

		userlabel = new JLabel(user.getU_name());
		userlabel.setForeground(Color.BLUE);
		userlabel.setFont(new Font("宋体", Font.BOLD, 20));
		userlabel.setBounds(83, 10, 110, 40);
		contentPane.add(userlabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 1002, 358);
		contentPane.add(scrollPane);

		model = new ContactTableModel(data);
		table = new JTable(model);
		table.setFont(new Font("微软雅黑", Font.BOLD, 16));
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		table.setRowHeight(51);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		rowSelectionModel.addListSelectionListener(e -> {
			select(e);
		});
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new CompoundBorder(null, new LineBorder(new Color(171, 173, 179))), "\u7F16\u8F91\u901A\u8BAF\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 427, 1008, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel namelabel = new JLabel("\u59D3\u540D\uFF1A");
		namelabel.setFont(new Font("宋体", Font.BOLD, 20));
		namelabel.setForeground(Color.BLUE);
		namelabel.setBackground(Color.WHITE);
		namelabel.setBounds(53, 35, 66, 40);
		panel.add(namelabel);

		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.BOLD, 20));
		nameField.setBounds(129, 43, 160, 30);
		panel.add(nameField);
		nameField.setColumns(10);

		JLabel phonelabel = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		phonelabel.setFont(new Font("宋体", Font.BOLD, 20));
		phonelabel.setForeground(Color.BLUE);
		phonelabel.setBounds(20, 98, 110, 40);
		panel.add(phonelabel);

		phoneField = new JTextField();
		phoneField.setFont(new Font("宋体", Font.BOLD, 20));
		phoneField.setBounds(129, 106, 160, 30);
		panel.add(phoneField);
		phoneField.setColumns(10);

		manradioButton = new JRadioButton("\u7537");
		manradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		manradioButton.addActionListener(e -> {
			sex = manradioButton.getText();
		});
		manradioButton.setForeground(Color.BLUE);
		manradioButton.setBounds(450, 44, 53, 23);
		panel.add(manradioButton);

		girlradioButton = new JRadioButton("\u5973");
		girlradioButton.setForeground(Color.BLUE);
		girlradioButton.setFont(new Font("宋体", Font.BOLD, 20));
		girlradioButton.addActionListener(e -> {
			sex = girlradioButton.getText();
		});
		girlradioButton.setBounds(523, 44, 53, 23);
		panel.add(girlradioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(manradioButton);
		bg.add(girlradioButton);

		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(372, 35, 66, 40);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u7535\u5B50\u90AE\u4EF6\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setForeground(Color.BLUE);
		label_3.setBounds(336, 98, 110, 40);
		panel.add(label_3);

		emailField = new JTextField();
		emailField.setFont(new Font("宋体", Font.BOLD, 20));
		emailField.setBounds(436, 106, 160, 30);
		panel.add(emailField);
		emailField.setColumns(10);

		JLabel label_4 = new JLabel("\u5730\u5740\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setForeground(Color.BLUE);
		label_4.setBounds(674, 35, 66, 40);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\u5907\u6CE8\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setForeground(Color.BLUE);
		label_5.setBounds(674, 98, 66, 40);
		panel.add(label_5);

		addrField = new JTextField();
		addrField.setFont(new Font("宋体", Font.BOLD, 20));
		addrField.setBounds(750, 43, 250, 30);
		panel.add(addrField);
		addrField.setColumns(10);

		sginField = new JTextField();
		sginField.setFont(new Font("宋体", Font.BOLD, 20));
		sginField.setBounds(750, 106, 250, 30);
		panel.add(sginField);
		sginField.setColumns(10);

		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setFont(new Font("宋体", Font.BOLD, 20));
		addButton.setBounds(53, 166, 120, 45);
		panel.add(addButton);
		// 注册添加联系人功能
		addButton.addActionListener(e -> {
			add(user);
		});

		JButton modifyButton = new JButton("\u4FEE\u6539");
		modifyButton.setFont(new Font("宋体", Font.BOLD, 20));
		modifyButton.setBounds(319, 166, 120, 45);
		panel.add(modifyButton);
		// 注册修改联系人功能
		modifyButton.addActionListener(e -> {
			modify(user);
		});

		JButton removeButton = new JButton("\u5220\u9664 ");
		removeButton.setFont(new Font("宋体", Font.BOLD, 20));
		removeButton.setBounds(584, 166, 120, 45);
		panel.add(removeButton);
		// 注册删除联系人功能
		removeButton.addActionListener(e -> {
			remove(user);
		});

		JButton exitbutton = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		exitbutton.setFont(new Font("宋体", Font.BOLD, 20));
		exitbutton.setBounds(827, 166, 120, 45);
		panel.add(exitbutton);
		// 注册退出系统功能
		exitbutton.addActionListener(e -> {
			if (JOptionPane.showConfirmDialog(null, "是否要退出系统？") == JOptionPane.OK_OPTION) {
				System.exit(0);
			} else {
				return;
			}
		});

		JTextPane searchTextField = new JTextPane();
		searchTextField.setFont(new Font("宋体", Font.BOLD, 20));
		searchTextField.setBounds(275, 10, 308, 39);
		contentPane.add(searchTextField);
		// 注册查询联系人功能
		searchTextField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				find(user, searchTextField);
			}
		});

		JButton findButton = new JButton("\u641C\u7D22");
		findButton.setFont(new Font("宋体", Font.BOLD, 20));
		findButton.setBounds(633, 10, 120, 40);
		contentPane.add(findButton);
		// 注册查询联系人功能
		findButton.addActionListener(e -> {
			find(user, searchTextField);
		});

		JLabel modifyPasswordlabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		modifyPasswordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyPasswordlabel.setForeground(Color.BLUE);
		modifyPasswordlabel.setFont(new Font("宋体", Font.BOLD, 20));
		modifyPasswordlabel.setBounds(902, 14, 110, 32);
		contentPane.add(modifyPasswordlabel);
		// 注册修改用户密码功能
		modifyPasswordlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modifyPassword();
			}
		});

		JLabel modifyUserinfolabel = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		modifyUserinfolabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyUserinfolabel.setForeground(Color.BLUE);
		modifyUserinfolabel.setFont(new Font("宋体", Font.BOLD, 20));
		modifyUserinfolabel.setBounds(763, 14, 145, 32);
		contentPane.add(modifyUserinfolabel);
		// 注册修改用户信息功能
		modifyUserinfolabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modifyUserinfo();
			}
		});

	}

	private void add(Userinfo user) {
		String name = nameField.getText().replace(" ", "");
		if (!name.equals("")) {
			if (phoneDao.findByName(user.getU_id(), name) == null) {
				String phoneNumber = phoneField.getText();
				String email = emailField.getText();
				String addr = addrField.getText();
				String sgin = sginField.getText();
				int u_id = user.getU_id();
				Phone phone = new Phone(name, phoneNumber, sex, email, addr, sgin, u_id);
				if (Tools.isNumerOfName(phone.getP_name()) == null) {
					JOptionPane.showMessageDialog(null, "添加失败,你输入的名字中含有数字");
				} else if (Tools.isPhoneNumber(phone.getP_number()) == null) {
					JOptionPane.showMessageDialog(null, "添加失败，你输入的电话号码中含有字符或者不是11位");
				} else if (Tools.isEmail(phone.getP_email()) == null) {
					JOptionPane.showMessageDialog(null, "添加失败，你输入的电子邮件格式不对");
				} else {
					if (userService.addContact(phone, phoneDao)) {
						JOptionPane.showMessageDialog(null, "添加成功");
					} else {
						JOptionPane.showMessageDialog(null, "添加失败");
					}
					data = userService.findContact(user.getU_id(), 0, null, phoneDao);
					flush();
					empty();
				}
			} else {
				JOptionPane.showMessageDialog(null, "添加失败，该联系人已存在");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
	}

	private void empty() {
		nameField.setText("");
		phoneField.setText("");
		manradioButton.setSelected(true);
		sex = "男";
		emailField.setText("");
		addrField.setText("");
		sginField.setText("");
	}

	private void modify(Userinfo user) {
		try {
			int p_id = data.get(selectedRow).getP_id();
			if (JOptionPane.showConfirmDialog(null, "是否确定要修改该联系人的信息？") == JOptionPane.OK_OPTION) {
				String name = nameField.getText().replace(" ", "");
				if (!name.equals("")) {
					int u_id = user.getU_id();
					if (data.get(selectedRow).getP_name().equals(name)) {
						modifyContact(p_id, name, u_id);
					} else {
						if (phoneDao.findByName(u_id, name) == null) {
							modifyContact(p_id, name, u_id);
						} else {
							JOptionPane.showMessageDialog(null, "修改失败，该联系人已经存在");
							return;
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "姓名不能为空");
					return;
				}
			} else {
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请先选择一位要修改的联系人");
		}
	}

	private void modifyContact(int p_id, String name, int u_id) {
		String phoneNumber = phoneField.getText();
		String email = emailField.getText();
		String addr = addrField.getText();
		String sgin = sginField.getText();
		Phone phone = new Phone(p_id, name, phoneNumber, sex, email, addr, sgin, u_id);
		if (Tools.isNumerOfName(phone.getP_name()) == null) {
			JOptionPane.showMessageDialog(null, "修改失败,你输入的名字中含有数字");
		} else if (Tools.isPhoneNumber(phone.getP_number()) == null) {
			JOptionPane.showMessageDialog(null, "修改失败，你输入的电话号码中含有字符或者不是11位");
		} else if (Tools.isEmail(phone.getP_email()) == null) {
			JOptionPane.showMessageDialog(null, "修改失败，你输入的电子邮件格式不对");
		} else {
			if (userService.modifyContact(phone, phoneDao)) {
				JOptionPane.showMessageDialog(null, "修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
			data = userService.findContact(u_id, 0, null, phoneDao);
			flush();
		}
	}

	private void remove(Userinfo user) {
		try {
			int p_id = data.get(selectedRow).getP_id();
			if (JOptionPane.showConfirmDialog(null, "是否确定要删除该联系人？") == JOptionPane.OK_OPTION) {
				int u_id = user.getU_id();
				if (userService.removeContact(p_id, phoneDao)) {
					JOptionPane.showMessageDialog(null, "删除成功");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
				data = userService.findContact(u_id, 0, null, phoneDao);
				flush();
				empty();
			} else {
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请先选择一位要删除的联系人");
		}
	}

	private void flush() {
		model = new ContactTableModel(data);
		table.setModel(model);
	}

	private void find(Userinfo user, JTextPane searchTextField) {
		String search = Tools.istring(searchTextField.getText());
		if (search == null) {
			try {
				data = userService.findContact(user.getU_id(), Integer.parseInt(searchTextField.getText()), null,
						phoneDao);
			} catch (NumberFormatException e1) {
				data = userService.findContact(user.getU_id(), 0, searchTextField.getText(), phoneDao);
			}
		} else if (!search.equals("")) {
			data = userService.findContact(user.getU_id(), 0, search, phoneDao);
		} else {
			data = userService.findContact(user.getU_id(), 0, null, phoneDao);
		}
		flush();
	}

	private void select(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			return;
		}
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		selectedRow = lsm.getMinSelectionIndex();
		if (selectedRow < 0) {
			return;
		}
		Phone phone = data.get(selectedRow);
		nameField.setText(phone.getP_name());
		phoneField.setText(phone.getP_number());
		if (phone.getP_sex().equals("男")) {
			manradioButton.setSelected(true);
		} else {
			girlradioButton.setSelected(true);
		}
		emailField.setText(phone.getP_email());
		addrField.setText(phone.getP_addr());
		sginField.setText(phone.getP_sign());
	}

	private void modifyPassword() {
		new ModifyPasswordWindow(this).setVisible(true);
		setVisible(false);
	}

	private void modifyUserinfo() {
		new ModifyUserinfoWindow(this).setVisible(true);
		setVisible(false);
	}
}
