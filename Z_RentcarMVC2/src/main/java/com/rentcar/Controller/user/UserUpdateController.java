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

public class UserUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user = new User(num, name, userid, pwd, email, phone);
		
		int cnt = UserDAO.getInstance().updateUser(user);
		if(cnt > 0) {
			String url = request.getContextPath() + "/rentcarMain.do";
			PrintWriter out = response.getWriter();
			ScriptFunction.alertLocation(name + "님 정보 수정완료!", url, out, response);
			return null;
		}
		return null;
	}

}
