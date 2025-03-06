package com.rentcar.Controller.user;

import java.io.IOException;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;
import com.rentcar.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		User user = UserDAO.getInstance().getUserInfo(name);
		
		HttpSession session = request.getSession();
		session.setAttribute("vo", user);
		
		return "userInfo";
	}

}
