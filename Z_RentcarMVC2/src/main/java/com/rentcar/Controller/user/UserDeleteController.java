package com.rentcar.Controller.user;

import java.io.IOException;

import com.mysql.cj.Session;
import com.rentcar.FrontController.Controller;
import com.rentcar.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pwd = request.getParameter("pwd");
		if(pwd == null) {
			return "userDelete";
		}
		String userid = request.getParameter("userid");
		String name = UserDAO.getInstance().checkUser(userid, pwd);
		if(name == null) {
			return "userInfo";
		}
		int cnt = UserDAO.getInstance().deleteUser(userid, pwd);
		if(cnt > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			String ctx = request.getContextPath();
//			response.sendRedirect(ctx + "/rentcarMain.do");
			request.setAttribute("msg", "회원 탈퇴가 완료되었습니다.");
		    request.setAttribute("url", ctx + "/rentcarMain.do");
		    return "printAlertMsg";
//			return "rentcarMain";
		}
		return null;
	}

}
