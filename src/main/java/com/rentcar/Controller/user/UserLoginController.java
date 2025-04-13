package com.rentcar.Controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("로그인 컨트롤러");
		String ctx = request.getContextPath();
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		if(id == null) {
			return "userLogin";
		}
		
		String pw = request.getParameter("pw");
		
		String name = UserDAO.getInstance().checkUser(id, pw);
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("log", name);
			String url = ctx + "/rentcarMain.do";
			ScriptFunction.alertLocation(name + "님 환영합니다.", url, out, response);
			return null;
		}
		ScriptFunction.alertBack("ID 혹은 PW를 확인해주세요", out, response);
		return null;
	}

}
