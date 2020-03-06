package com.luosen.demo.dao.impl;

import com.luosen.demo.dao.UserinfoDao;
import com.luosen.demo.domain.Userinfo;

public class UserinfoDaoImpl extends BaseDaoImpl<UserinfoDao> implements UserinfoDao{
	public UserinfoDaoImpl() {
		this.setMapper(UserinfoDao.class);
	}

	@Override
	public Userinfo findByUid(int u_id) {
		return this.getMapper().findByUid(u_id);
	}

	@Override
	public int create(Userinfo userinfo) {
		int count=0;
		count= this.getMapper().create(userinfo);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public int modify(Userinfo userinfo) {
		int count=0;
		count= this.getMapper().modify(userinfo);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public int modifyPassword(String u_password, int u_id) {
		int count=0;
		count=this.getMapper().modifyPassword(u_password, u_id);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public Userinfo findByUname(String u_name) {
		return this.getMapper().findByUname(u_name);
	}

}
