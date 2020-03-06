package com.luosen.demo.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDaoImpl <T>{
	SqlSessionFactory sqlsessionFactory;
	SqlSession sqlSession;
	Class<T> mapper;
	public BaseDaoImpl() {
		try {
			InputStream is=Resources.getResourceAsStream("Mybatis.xml");
			sqlsessionFactory=new SqlSessionFactoryBuilder().build(is);
			sqlSession=sqlsessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public T getMapper() {
		return sqlSession.getMapper(mapper);
	}
	public void setMapper(Class<T> mapper) {
		this.mapper = mapper;
	}
}
