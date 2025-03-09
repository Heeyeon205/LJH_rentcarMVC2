package com.rentcar.Controller.rentcar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentcar.FrontController.Controller;
import com.rentcar.dao.RentcarDAO;
import com.rentcar.vo.Rentcar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RentcarFilterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌터카 체크박스 필터 컨트롤러");

		String[] company = request.getParameterValues("company");
		String[] category = request.getParameterValues("category");
		String[] usepeople = request.getParameterValues("usepeople");

		HashMap<String, Object> filterMap = new HashMap<>();
		filterMap.put("company", company);
		filterMap.put("category", category);
		filterMap.put("usepeople", usepeople);

		ArrayList<Rentcar> list = RentcarDAO.getInstance().getFilterCar(filterMap);
		
		response.setContentType("application/json; charset=UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(list);

		PrintWriter out = response.getWriter();
		out.write(jsonResponse);
		out.flush();
		return null;
	}
}
