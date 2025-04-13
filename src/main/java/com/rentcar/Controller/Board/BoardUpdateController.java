package com.rentcar.Controller.Board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.BoardDAO;
import com.rentcar.dao.RentcarDAO;
import com.rentcar.dao.ReservationDAO;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;
import com.rentcar.vo.Board;
import com.rentcar.vo.Rentcar;
import com.rentcar.vo.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("문의글 수정 컨트롤러");
		
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		request.setAttribute("writer", writer);
		request.setAttribute("subject", subject);
		
		String newSubject = request.getParameter("newSubject");
		if(newSubject == null) {
			return "boardUpdate";
		}
		
		String newContents = request.getParameter("newContents");
		
		System.out.println(newSubject);
		System.out.println(newContents);
		
		int no = BoardDAO.getInstance().getBoardNoByUserId(writer);
		Board board = new Board(no, newSubject, newContents);
		int cnt = BoardDAO.getInstance().updateBoard(board);
		System.out.println("쿼리 밖 cnt : " + cnt);
		
		HttpSession session = request.getSession();
		String logName = (String) session.getAttribute("log");
		PrintWriter out = response.getWriter();
		System.out.println("response is committed: " + response.isCommitted());
		if(cnt > 0) {
			String url = request.getContextPath() + "/rentcarCustomerCenter.do";
			ScriptFunction.alertLocation(logName + "님 문의글 수정 완료.", url, out, response);
			return null;
		}
		return null;
	}
}
