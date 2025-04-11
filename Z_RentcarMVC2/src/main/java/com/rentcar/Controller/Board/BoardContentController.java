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

public class BoardContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("문의 게시글 보기 컨트롤러");
		
		HttpSession session = request.getSession();
		String logName = (String) session.getAttribute("log");
		
		int boardNo = Integer.parseInt(request.getParameter("no"));
		Board board = BoardDAO.getInstance().getBoardInfoByNo(boardNo);
		String writer = board.getWriter();
		String subject = board.getSubject();
		String contents = board.getContents();
		request.setAttribute("writer", writer);
		request.setAttribute("subject", subject);
		request.setAttribute("contents", contents);
		
		String userid = UserDAO.getInstance().getUserId(logName);
		request.setAttribute("userid", userid);
		
		return "boardContent";
	}
}
