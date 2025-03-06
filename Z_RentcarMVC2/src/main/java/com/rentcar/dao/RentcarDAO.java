package com.rentcar.dao;

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
	
//	public boolean isValidUser() {
//		SqlSession session = MybatisConfig.getInstance().openSession(true);
//		List<Rentcar> list = session.selectList("mapper.rentcar.getRecentCarList");
//		session.close();
//		return list;
//	}
}
