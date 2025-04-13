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

public class BoardInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("문의 작성 컨트롤러");

		HttpSession session = request.getSession();
		String logName = (String) session.getAttribute("log");
		PrintWriter out = response.getWriter();

		if (logName == null) {
			ScriptFunction.alertBack("로그인 후 이용해주세요.", out, response);
			return null;
		}

		String userid = UserDAO.getInstance().getUserId(logName);
		request.setAttribute("userid", userid);

		String subject = request.getParameter("subject");
		if (subject == null) {
			return "boardInsert";
		}
		String contents = request.getParameter("contents");
		
		System.out.println("userid/writer : " + userid);
		System.out.println("subject : " + subject);
		System.out.println("contents : " + contents);
		
		Board board = new Board(userid, subject, contents);
		int cnt = BoardDAO.getInstance().insertBoard(board);
		System.out.println("서블릿에 있는 cnt : " + cnt);
		if(cnt > 0) {
			String url = request.getContextPath() + "/rentcarCustomerCenter.do";
			ScriptFunction.alertLocation(logName + "님 문의 글 작성 완료.", url, out, response);
			return null;
		}
		return null;
	}
}
