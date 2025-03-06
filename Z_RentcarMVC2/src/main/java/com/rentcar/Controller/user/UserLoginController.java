package com.rentcar.Controller.user;

import java.io.IOException;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		String id = request.getParameter("id");
		if(id == null) {
			System.out.println("id못받음");
//			return "redirect:" + ctx + "/userLogin.jsp";
			return "userLogin";
		}
		String pw = request.getParameter("pw");
		
		System.out.println("id받음");
		System.out.println(id);
		System.out.println(pw);
		
		String name = UserDAO.getInstance().checkLogin(id, pw);
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("log", name);
			return "rentcarMain";
		}
		return null;
	}

}
