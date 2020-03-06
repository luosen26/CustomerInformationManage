package com.luosen.demo.mainapp;

import com.luosen.demo.controller.UserService;
import com.luosen.demo.controller.impl.UserServiceImpl;
import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.dao.impl.UserinfoDaoImpl;
import com.luosen.demo.ui.LoginWindow;

public class MainApp {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UserinfoDao userinfoDao = new UserinfoDaoImpl();
		UserService userinfoService = new UserServiceImpl();
		new LoginWindow(userinfoDao, userinfoService).setVisible(true);
	}
}
