package com.rentcar.Controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;
import com.rentcar.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("유저 회원가입 컨트롤러");
		
		String userid = request.getParameter("userid");
		if(userid == null) {
			return "userInsert";
		}
		
		String ctx = request.getContextPath();
		PrintWriter out = response.getWriter();
		
		int num = 0;
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user = new User(num, name, userid, pwd, email, phone);
		
		int cnt = UserDAO.getInstance().insertUser(user);
		if(cnt > 0) {
			String url = ctx + "/rentcarMain.do";
			ScriptFunction.alertLocation(name + "님 회원가입 완료.", url, out, response);
			return null;
		}
		return null;
	}

}
