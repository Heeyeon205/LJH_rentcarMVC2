package com.rentcar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rentcar.vo.Rentcar;

public class RentcarDAO {
	private static RentcarDAO instance;

	private RentcarDAO() {
	}

	public static RentcarDAO getInstance() {
		if (instance == null) {
			instance = new RentcarDAO();
		}
		return instance;
	}
	
	private static SqlSessionFactory sqlSessionFactory;
	private static String nameSpace = "com.rentcar.mybatis.RentcarMapper.";
	
	static {
		try {
			String resource = "com/rentcar/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public ArrayList<Rentcar> getRentcarList() {
	        ArrayList<Rentcar> list = null;
	        try (SqlSession session = sqlSessionFactory.openSession()) {
	            list = (ArrayList) session.selectList(nameSpace + "getRentcarList");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	public ArrayList<Rentcar> getFilterCar(HashMap<String, Object> filterMap) {
		ArrayList<Rentcar> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
            list = (ArrayList) session.selectList(nameSpace + "getFilterCar", filterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}
	
}
