package com.rentcar.Controller.rentcar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.RentcarDAO;
import com.rentcar.utils.ScriptFunction;
import com.rentcar.vo.Rentcar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RentcarReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌터카 예약 컨트롤러");

		HttpSession session = request.getSession();
		String logName = (String) session.getAttribute("log");
		PrintWriter out = response.getWriter();

		String firstDay = request.getParameter("firstDay");
		String lastDay = request.getParameter("lastDay");
		if (firstDay == null) {
			return "rentcarReservation";
		}

		if (request.getParameter("period").equals("")) {
			ScriptFunction.alertBack("날짜를 선택해주세요.", out, response);
		}

		int period = Integer.parseInt(request.getParameter("period"));
		String firstMonth = request.getParameter("firstMonth");
		String lastMonth = request.getParameter("lastMonth");

		if (logName == null) {
			ScriptFunction.alertBack("로그인 후 이용해주세요.", out, response);
			return null;
		}

		request.setAttribute("firstDay", firstDay);
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("period", period);
		request.setAttribute("firstMonth", firstMonth);
		request.setAttribute("lastMonth", lastMonth);

		ArrayList<Rentcar> list = RentcarDAO.getInstance().getRentcarList();
		request.setAttribute("list", list);
		return "rentcarChoice";
	}
}
