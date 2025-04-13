package com.rentcar.Controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import com.rentcar.FrontController.Controller;
import com.rentcar.dao.BoardDAO;
import com.rentcar.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RentcarCustomerCenterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌터카 고객센터 컨트롤러");
		
		int page = 1; 
        int pageSize = 10; 
        int pageGroupSize = 5; 

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        int totalCount = BoardDAO.getInstance().getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        int currentPageGroup = (int) Math.ceil((double) page / pageGroupSize);
        int startPage = (currentPageGroup - 1) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        ArrayList<Board> boardList = BoardDAO.getInstance().getBoardList(page, pageSize);

        request.setAttribute("boardList", boardList);
        request.setAttribute("page", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
		
		return "rentcarCustomerCenter";
	}
}
