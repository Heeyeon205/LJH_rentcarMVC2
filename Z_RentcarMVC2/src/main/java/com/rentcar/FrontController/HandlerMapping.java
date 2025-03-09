package com.rentcar.FrontController;

import java.util.HashMap;

import com.rentcar.Controller.Board.BoardContentController;
import com.rentcar.Controller.Board.BoardDeleteController;
import com.rentcar.Controller.Board.BoardInsertController;
import com.rentcar.Controller.Board.BoardUpdateController;
import com.rentcar.Controller.rentcar.RentcarChoiceController;
import com.rentcar.Controller.rentcar.RentcarCustomerCenterController;
import com.rentcar.Controller.rentcar.RentcarFilterController;
import com.rentcar.Controller.rentcar.RentcarMainController;
import com.rentcar.Controller.rentcar.RentcarReservationController;
import com.rentcar.Controller.rentcar.RentcarReservationListController;
import com.rentcar.Controller.user.UserDeleteController;
import com.rentcar.Controller.user.UserInfoController;
import com.rentcar.Controller.user.UserInsertController;
import com.rentcar.Controller.user.UserLoginController;
import com.rentcar.Controller.user.UserLogoutController;
import com.rentcar.Controller.user.UserUpdateController;
import com.rentcar.Controller.user.ValidIdAjaxController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<>();
		// 유저 관리
		mappings.put("/userLogin.do", new UserLoginController());
		mappings.put("/userLogout.do", new UserLogoutController());
		mappings.put("/userInfo.do", new UserInfoController());
		mappings.put("/userUpdate.do", new UserUpdateController());
		mappings.put("/userInsert.do", new UserInsertController());
		mappings.put("/validIdAjax.do", new ValidIdAjaxController());
		mappings.put("/userDelete.do", new UserDeleteController());
		
		// 렌터카 관리
		mappings.put("/rentcarMain.do", new RentcarMainController());
		mappings.put("/rentcarReservation.do", new RentcarReservationController());
		mappings.put("/rentcarChoice.do", new RentcarChoiceController());
		mappings.put("/rentcarFilter.do", new RentcarFilterController());
		mappings.put("/rentcarReservationList.do", new RentcarReservationListController());
		
		// 고객센터 관리
		mappings.put("/rentcarCustomerCenter.do", new RentcarCustomerCenterController());
		mappings.put("/boardInsert.do", new BoardInsertController());
		mappings.put("/boardDelete.do", new BoardDeleteController());
		mappings.put("/boardContent.do", new BoardContentController());
		mappings.put("/boardUpdate.do", new BoardUpdateController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}