package com.rentcar.dao;

import java.io.IOException;
import java.io.InputStream;
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
	private static SqlSession session;
	
	static {
		try {
			String resource = "com/rentcar/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String checkUser(String userid, String pwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("pwd", pwd);
		session = sqlSessionFactory.openSession();
		String name = session.selectOne("checkLogin", params);
		session.close();
		return name;
	}

	public User getUserInfo(String name) {
		session = sqlSessionFactory.openSession();
		User user = session.selectOne("getUserInfo", name);
		session.close();
		return user;
	}

	public int updateUser(User user) {
		session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = session.update("updateUser", user);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int isDupId(String userid) {
		session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = session.selectOne("isDupId", userid);
		session.close();
		System.out.println("cnt: " + cnt);
		return cnt;
	}

	public int insertUser(User user) {
		session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = session.insert("insertUser", user);
		session.commit();
		session.close();
		return cnt;
	}

	public int deleteUser(String userid, String pwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("pwd", pwd);
		session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = session.delete("deleteUser", params);
		System.out.println("deleteCnt: " + cnt);
		session.commit();
		session.close();
		return cnt;
	}
}
