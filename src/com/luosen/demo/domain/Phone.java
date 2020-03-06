package com.luosen.demo.domain;

public class Phone {
	private int p_id;
	private String p_name;
	private String p_number;
	private String p_sex;
	private String p_email;
	private String p_addr;
	private String p_sign;
	private int u_id;
	public Phone(int p_id, String p_name, String p_number, String p_sex, String p_email, String p_addr, String p_sign,
			int u_id) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_number = p_number;
		this.p_sex = p_sex;
		this.p_email = p_email;
		this.p_addr = p_addr;
		this.p_sign = p_sign;
		this.u_id = u_id;
	}
	public Phone(String p_name, String p_number, String p_sex, String p_email, String p_addr, String p_sign, int u_id) {
		super();
		this.p_name = p_name;
		this.p_number = p_number;
		this.p_sex = p_sex;
		this.p_email = p_email;
		this.p_addr = p_addr;
		this.p_sign = p_sign;
		this.u_id = u_id;
	}
	public Phone() {
		super();
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_number() {
		return p_number;
	}
	public void setP_number(String p_number) {
		this.p_number = p_number;
	}
	public String getP_sex() {
		return p_sex;
	}
	public void setP_sex(String p_sex) {
		this.p_sex = p_sex;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public String getP_addr() {
		return p_addr;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	public String getP_sign() {
		return p_sign;
	}
	public void setP_sign(String p_sign) {
		this.p_sign = p_sign;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Phone [p_id=" + p_id + ", p_name=" + p_name + ", p_number=" + p_number + ", p_sex=" + p_sex
				+ ", p_email=" + p_email + ", p_addr=" + p_addr + ", p_sign=" + p_sign + ", u_id=" + u_id + "]";
	}
	
	
	

}
