package com.luosen.demo.dao.impl;

import java.util.List;

import com.luosen.demo.dao.PhoneDao;
import com.luosen.demo.domain.Phone;

public class PhoneDaoImpl extends BaseDaoImpl<PhoneDao> implements PhoneDao{
	public PhoneDaoImpl() {
		this.setMapper(PhoneDao.class);
	}

	@Override
	public List<Phone> find(int u_id,int p_id,String p_name) {
		return this.getMapper().find(u_id, p_id, p_name);
	}

	@Override
	public int create(Phone phone) {
		int count=0;
		count=this.getMapper().create(phone);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public int modify(Phone phone) {
		int count=0;
		count=this.getMapper().modify(phone);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public int remove(int p_id) {
		int count=0;
		count=this.getMapper().remove(p_id);
		this.sqlSession.commit();
		return count;
	}

	@Override
	public Phone findByName(int u_id, String p_name) {
		return this.getMapper().findByName(u_id, p_name);
	}

}
