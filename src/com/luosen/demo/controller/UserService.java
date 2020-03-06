package com.luosen.demo.controller;

import java.util.List;

import com.luosen.demo.dao.PhoneDao;
import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.domain.Phone;
import com.luosen.demo.domain.Userinfo;

public interface UserService {
	public boolean userLogin(int id,String password,UserinfoDao userinfoDao);
	public boolean userRegister(Userinfo userinfo,UserinfoDao userinfoDao);
	public boolean modifyUserinfo(Userinfo userinfo,UserinfoDao userinfoDao);
	public boolean modifyUserPassword(String u_password,int u_id,UserinfoDao userinfoDao);
	public List<Phone> findContact(int u_id,int p_id,String p_name,PhoneDao phoneDao);
	public boolean addContact(Phone phone,PhoneDao phoneDao);
	public boolean modifyContact(Phone phone,PhoneDao phoneDao);
	public boolean removeContact(int p_id,PhoneDao phoneDao);
}
