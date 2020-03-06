package com.luosen.demo.controller.impl;
import java.util.List;

import com.luosen.demo.controller.UserService;
import com.luosen.demo.dao.PhoneDao;
import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.domain.Phone;
import com.luosen.demo.domain.Userinfo;

public class UserServiceImpl implements UserService{

	@Override
	public boolean userLogin(int id, String password, UserinfoDao userinfoDao) {
		Userinfo u=userinfoDao.findByUid(id);
		if (u==null) {
			return false;
		}else {
			if (u.getU_password().equals(password)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	@Override
	public List<Phone> findContact(int u_id,int p_id,String p_name,PhoneDao phoneDao) {
		return phoneDao.find(u_id, p_id, p_name);
	}
	
	@Override
	public boolean addContact(Phone phone, PhoneDao phoneDao) {
		if (phoneDao.create(phone)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userRegister(Userinfo userinfo, UserinfoDao userinfoDao) {
		if (userinfoDao.create(userinfo)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeContact(int p_id, PhoneDao phoneDao) {
		if (phoneDao.remove(p_id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyContact(Phone phone, PhoneDao phoneDao) {
		if (phoneDao.modify(phone)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyUserPassword(String u_password, int u_id, UserinfoDao userinfoDao) {
		if (userinfoDao.modifyPassword(u_password, u_id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyUserinfo(Userinfo userinfo, UserinfoDao userinfoDao) {
		if (userinfoDao.modify(userinfo)>0) {
			return true;
		}
		return false;
	}

}
