package com.luosen.demo.utils;

import java.awt.Point;
import java.awt.Toolkit;

public class Tools {
	public static String istring(String str) {
		str = str.replace(" ", "");
		byte[] buf = str.getBytes();
		for (int i = 0; i < buf.length; i++) {
			if (48 <= buf[i] && buf[i] <= 57) {
				return null;
			}
		}
		return str;
	}

	public static String isPhoneNumber(String number) {
		number = number.replace(" ", "");
		if (number.length() == 11) {
			byte[] buf = number.getBytes();
			for (int i = 0; i < buf.length; i++) {
				if (48 <= buf[i] && buf[i] <= 57) {
					continue;
				} else {
					return null;
				}
			}
			return number;
		} else {
			return null;
		}
	}

	public static String isNumerOfName(String name) {
		name = name.replace(" ", "");
		byte[] buf = name.getBytes();
		for (int i = 0; i < buf.length; i++) {
			if (48 <= buf[i] && buf[i] <= 57) {
				return null;
			}
		}
		return name;
	}

	public static String isEmail(String email) {
		email = email.replace(" ", "");
		if (email.endsWith(".com") || email.endsWith(".com.cn")) {
			int first = email.indexOf("@");
			if (first!=0) {
				if (first == -1) {
					return null;
				} else {
					int last = email.lastIndexOf("@");
					if (first == last) {
						return email;
					} else {
						return null;
					}
				}
			}else {
				return null;
			}
		} else {
			return null;
		}
	}
	public static Point getPostion(int width,int height){
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int x = (int) (screenWidth - width)/2;
		int y = (int) (screenHeight - height)/2;
		return new Point(x, y);
	}
}
