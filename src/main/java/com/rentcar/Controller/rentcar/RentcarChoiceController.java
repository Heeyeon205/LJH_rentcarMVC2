package com.rentcar.Controller.rentcar;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.ReservationDAO;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;
import com.rentcar.vo.Reservation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RentcarChoiceController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌터카 차량 선택 컨트롤러");

		int rentcarNum = 0;
		if (request.getParameter("carNum") == null) {
			return "rentcarChoice";
		}

		PrintWriter out = response.getWriter();
		if (request.getParameter("carNum").equals("")) {
			ScriptFunction.alertBack("차량을 선택해주세요", out, response);
			return null;
		}

		rentcarNum = Integer.parseInt(request.getParameter("carNum"));
		if (rentcarNum == 0) {
			return null;
		}

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("log");

		String userid = UserDAO.getInstance().getUserId(userName);
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dday = Integer.parseInt(request.getParameter("dday"));

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String rday = today.format(formatter);

		int usein = request.getParameter("usein") != null ? 1 : 0;
		int usewifi = request.getParameter("usewifi") != null ? 1 : 0;
		int usenavi = request.getParameter("usenavi") != null ? 1 : 0;
		int useseat = request.getParameter("useseat") != null ? 1 : 0;

		Reservation reservation = new Reservation(0, rentcarNum, userid, qty, dday, rday, usein, usewifi, usenavi,
				useseat);

		int cnt = ReservationDAO.getInstance().insertReservation(reservation);
		if (cnt > 0) {
			String url = request.getContextPath() + "/rentcarMain.do";
			ScriptFunction.alertLocation("예약이 완료되었습니다.", url, out, response);
		}
		return null;
	}
}
