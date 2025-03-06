package com.rentcar.Controller.rentcar;

import java.io.IOException;

import com.rentcar.FrontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RentcarMainController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
//		return "redirect:" + ctx + "/main.jsp";
		return "rentcarMain";
	}
}
