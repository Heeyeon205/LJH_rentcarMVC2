package com.rentcar.FrontController;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024
		* 1024 * 5 * 5)
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String url = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = url.substring(ctx.length());
		
		 System.out.println("호출 URI: " + url);
		    System.out.println("contextPath: " + ctx);
		    System.out.println("command: " + command);

		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(command);

		String nextPage = controller.requestHandler(request, response);
		System.out.println("nextPage : " + nextPage);

		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") != -1) {
				System.out.println(nextPage.split(":")[1]);
				response.sendRedirect(nextPage.split(":")[1]);
			} else {
				RequestDispatcher rd = null;
				if (nextPage.contains("rentcar")) {
					rd = request.getRequestDispatcher(ViewResolver.makeViewRentcar(nextPage));
				} else if (nextPage.contains("user")) {
					rd = request.getRequestDispatcher(ViewResolver.makeViewUser(nextPage));
				} else if (nextPage.contains("board")) {
					rd = request.getRequestDispatcher(ViewResolver.makeViewBoard(nextPage));
				}
				rd.forward(request, response);
			}
		}
	}
}