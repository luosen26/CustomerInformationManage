package com.luosen.demo.domain;

public class Userinfo {
	private int u_id;
	private String u_name;
	private String u_password;
	private String u_addr;
	private String u_sex;
	private String u_createDate;
	public Userinfo(int u_id, String u_name, String u_password, String u_addr, String u_sex, String u_createDate) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_addr = u_addr;
		this.u_sex = u_sex;
		this.u_createDate = u_createDate;
	}
	public Userinfo(String u_name, String u_password, String u_addr, String u_sex, String u_createDate) {
		super();
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_addr = u_addr;
		this.u_sex = u_sex;
		this.u_createDate = u_createDate;
	}
	public Userinfo() {
		super();
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_addr() {
		return u_addr;
	}
	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_createDate() {
		return u_createDate;
	}
	public void setU_createDate(String u_createDate) {
		this.u_createDate = u_createDate;
	}
	@Override
	public String toString() {
		return "Userinfo [u_id=" + u_id + ", u_name=" + u_name + ", u_password=" + u_password + ", u_addr=" + u_addr
				+ ", u_sex=" + u_sex + ", u_createDate=" + u_createDate + "]";
	}
	
}
