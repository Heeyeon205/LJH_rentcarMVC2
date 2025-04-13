package com.rentcar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rentcar.vo.Reservation;

public class ReservationDAO {
	private static ReservationDAO instance;

	private ReservationDAO() {
	}

	public static ReservationDAO getInstance() {
		if (instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}

	private static SqlSessionFactory sqlSessionFactory;
	private static String nameSpace = "com.rentcar.mybatis.ReservationMapper.";

	static {
		try {
			String resource = "com/rentcar/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReservation(Reservation reservation) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.insert(nameSpace + "insertReservation", reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public ArrayList<Reservation> getReservationList() {
		ArrayList<Reservation> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = (ArrayList) session.selectList(nameSpace + "getReservationList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Reservation> getReservationListByUserId(String userid) {
		ArrayList<Reservation> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = (ArrayList) session.selectList(nameSpace + "getReservationListByUserId", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
