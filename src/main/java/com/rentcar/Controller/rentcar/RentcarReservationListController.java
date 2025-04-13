package com.rentcar.Controller.rentcar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.RentcarDAO;
import com.rentcar.dao.ReservationDAO;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;
import com.rentcar.vo.Rentcar;
import com.rentcar.vo.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RentcarReservationListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌터카 예약 리스트 출력 컨트롤러");

		HttpSession session = request.getSession();
		String logName = (String) session.getAttribute("log");
		PrintWriter out = response.getWriter();

		if (logName == null) {
			ScriptFunction.alertBack("로그인 후 이용해주세요.", out, response);
			return null;
		}
		
		if (logName.equals("관리자")) {
			ArrayList<Reservation> wholeList = ReservationDAO.getInstance().getReservationList();
			request.setAttribute("list", wholeList);
			return "rentcarReservationList";
		}
		
		String userid = UserDAO.getInstance().getUserId(logName);
		ArrayList<Reservation> list = ReservationDAO.getInstance().getReservationListByUserId(userid);
		request.setAttribute("list", list);
		return "rentcarReservationList";
	}
}
