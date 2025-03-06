package com.rentcar.Controller.user;

import java.io.IOException;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String ctx = request.getContextPath();
		response.sendRedirect(ctx + "/rentcarMain.do");
		return null;
	}

}
