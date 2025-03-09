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
	private static String nameSpace = "com.rentcar.mybatis.UserMapper.";

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
		String name = "";
		params.put("userid", userid);
		params.put("pwd", pwd);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			name = session.selectOne(nameSpace + "checkLogin", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public User getUserInfo(String name) {
		User user = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			user = session.selectOne(nameSpace + "getUserInfo", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int updateUser(User user) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.update(nameSpace + "updateUser", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public int isDupId(String userid) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.selectOne(nameSpace + "isDupId", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public int insertUser(User user) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.insert(nameSpace + "insertUser", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public int deleteUser(String userid, String pwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("pwd", pwd);
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.delete("deleteUser", params);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public String getUserId(String name) {
		String userid = "";
		try (SqlSession session = sqlSessionFactory.openSession()) {
			userid = session.selectOne(nameSpace + "getUserId", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userid;
	}
}
