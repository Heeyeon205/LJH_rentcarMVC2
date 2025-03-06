package com.rentcar.dao;

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
	
//	public boolean isValidUser() {
//		SqlSession session = MybatisConfig.getInstance().openSession(true);
//		List<Rentcar> list = session.selectList("mapper.rentcar.getRecentCarList");
//		session.close();
//		return list;
//	}
}
