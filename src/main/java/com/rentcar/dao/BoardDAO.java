package com.rentcar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rentcar.vo.Board;

public class BoardDAO {

	private static BoardDAO instance;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private static SqlSessionFactory sqlSessionFactory;
	private static String nameSpace = "com.rentcar.mybatis.BoardMapper.";
	
	static {
		try {
			String resource = "com/rentcar/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> getAllBoardList() {
		ArrayList<Board> list = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = (ArrayList) session.selectList(nameSpace + "getAllBoardList");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	public int getTotalBoardCount() {
		int cnt = 0;
        try (SqlSession session = sqlSessionFactory.openSession()) {
        	cnt = session.selectOne(nameSpace + "getTotalBoardCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return cnt;
	}

	public ArrayList<Board> getBoardList(int page, int pageSize) {
		HashMap<String, Integer> params = new HashMap<>();
		params.put("pageSize", pageSize);
	    params.put("offset", (page - 1) * pageSize);
		ArrayList<Board> list = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = (ArrayList) session.selectList(nameSpace + "getBoardList", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	public int insertBoard(Board board) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
            cnt = session.insert(nameSpace + "insertBoard", board);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
	}

	public int deleteBoard(int no) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
            cnt = session.delete(nameSpace + "deleteBoard", no);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
	}

	public int getBoardNoByUserId(String userid) {
		int userBoardNo = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			userBoardNo = session.selectOne(nameSpace + "getBoardNoByUserId", userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBoardNo;
	}

	public Board getBoardInfoByNo(int boardNo) {
		Board board = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			board = session.selectOne(nameSpace + "getBoardInfoByNo", boardNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
	}

	public int updateBoard(Board board) {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.update(nameSpace + "updateBoard", board);
			session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("쿼리 안 cnt : " + cnt);
        return cnt;
	}

}