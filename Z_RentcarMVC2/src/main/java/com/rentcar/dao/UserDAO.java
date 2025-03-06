package com.rentcar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rentcar.vo.User;

public class UserDAO {
	private static UserDAO instance;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/rentcar/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String checkLogin(String userid, String pwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("pwd", pwd);
		SqlSession session = sqlSessionFactory.openSession();
		String name = session.selectOne("checkLogin", params);
		session.close();
		return name;
	}
	
	public User getUserInfo(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("getUserInfo", name);
		return user;
	}
}
