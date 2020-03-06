package com.luosen.demo.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luosen.demo.domain.Phone;

public interface PhoneDao {
	public List<Phone> find(@Param("u_id")int u_id,@Param("p_id")int p_id,@Param("p_name")String p_name);
	public Phone findByName(@Param("u_id")int u_id,@Param("p_name")String p_name);
	public int create(Phone phone);
	public int modify(Phone phone);
	public int remove(int p_id);
}
