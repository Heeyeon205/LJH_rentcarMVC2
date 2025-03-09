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

public class BoardDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("관리자 문의 게시글 삭제 컨트롤러");

		int no = Integer.parseInt(request.getParameter("no"));
		int cnt = BoardDAO.getInstance().deleteBoard(no);

		if(cnt > 0) {
			PrintWriter out = response.getWriter();
			String url = request.getContextPath() + "/rentcarCustomerCenter.do";
			ScriptFunction.alertLocation("해당 문의글 삭제 완료", url, out, response);
			return null;
		}
		return null;
	}
}
