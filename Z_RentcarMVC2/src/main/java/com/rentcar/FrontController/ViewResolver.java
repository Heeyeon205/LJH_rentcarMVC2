package com.rentcar.FrontController;

public class ViewResolver {
	
	public static String makeViewUser(String nextPage) {
		return "/WEB-INF/user/" + nextPage + ".jsp";
	}
	
	public static String makeViewRentcar(String nextPage) {
		return "/WEB-INF/rentcar/" + nextPage + ".jsp";
	}
}
