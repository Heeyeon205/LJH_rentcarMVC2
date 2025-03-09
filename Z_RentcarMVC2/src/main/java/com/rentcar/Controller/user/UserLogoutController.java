package com.rentcar.Controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.rentcar.FrontController.Controller;
import com.rentcar.utils.ScriptFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그아웃 컨트롤러");

		HttpSession session = request.getSession();
		session.invalidate();

		String ctx = request.getContextPath();
		String url = ctx + "/rentcarMain.do";
		PrintWriter out = response.getWriter();
		ScriptFunction.alertLocation("로그아웃 완료.", url, out, response);
		return null;
	}

}
