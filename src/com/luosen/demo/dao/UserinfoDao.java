package com.luosen.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.luosen.demo.domain.Userinfo;

public interface UserinfoDao {
	public Userinfo findByUid(int u_id);
	public Userinfo findByUname(String u_name);
	public int create(Userinfo userinfo);
	public int modify(Userinfo userinfo);
	public int modifyPassword(@Param("u_password")String u_password,@Param("u_id")int u_id);
}
