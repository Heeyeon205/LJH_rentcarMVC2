package com.rentcar.Controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.Session;
import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;
import com.rentcar.utils.ScriptFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("유저 탈퇴 컨트롤러");
		
		String pwd = request.getParameter("pwd");
		if(pwd == null) {
			return "userDelete";
		}
		
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String name = UserDAO.getInstance().checkUser(userid, pwd);
		if(name == null) {
			ScriptFunction.alertBack("PW가 일치하지 않습니다.", out, response);
			return null;
		}
		
		int cnt = UserDAO.getInstance().deleteUser(userid, pwd);
		if(cnt > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			String url = request.getContextPath() + "/rentcarMain.do";
			ScriptFunction.alertLocation("회원탈퇴 완료. 안녕히 가십시오.", url, out, response);
		    return null;
		}
		return null;
	}

}
