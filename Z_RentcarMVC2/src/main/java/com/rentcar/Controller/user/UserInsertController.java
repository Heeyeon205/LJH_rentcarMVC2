package com.rentcar.Controller.user;

import java.io.IOException;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;
import com.rentcar.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		if(userid == null) {
			System.out.println("로그인 jsp로");
			return "userInsert";
		}
		
		int check = UserDAO.getInstance().isDupId(userid);
		if(check > 0) {
			return "userInsert";
		}
		
		int num = 0;
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user = new User(num, name, userid, pwd, email, phone);
		
		int cnt = UserDAO.getInstance().insertUser(user);
		if(cnt > 0) {
			return "rentcarMain";
		}
		return null;
	}

}
