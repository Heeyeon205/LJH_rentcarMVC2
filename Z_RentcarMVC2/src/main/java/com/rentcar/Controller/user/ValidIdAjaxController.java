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

public class ValidIdAjaxController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("유저 아이디 중복 확인 컨트롤러");
		
		String userid = request.getParameter("id");
        int check = UserDAO.getInstance().isDupId(userid);
        if (check > 0) {
            response.getWriter().print("notValid");
        } else {
            response.getWriter().print("valid");
        }
        return null;
	}

}
