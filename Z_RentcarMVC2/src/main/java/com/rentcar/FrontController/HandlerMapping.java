package com.rentcar.FrontController;

import java.util.HashMap;

import com.rentcar.Controller.rentcar.RentcarMainController;
import com.rentcar.Controller.user.UserDeleteController;
import com.rentcar.Controller.user.UserInfoController;
import com.rentcar.Controller.user.UserInsertController;
import com.rentcar.Controller.user.UserLoginController;
import com.rentcar.Controller.user.UserLogoutController;
import com.rentcar.Controller.user.UserUpdateController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<>();
		mappings.put("/rentcarMain.do", new RentcarMainController());
		mappings.put("/userLogin.do", new UserLoginController());
		mappings.put("/userLogout.do", new UserLogoutController());
		mappings.put("/userInfo.do", new UserInfoController());
		mappings.put("/userUpdate.do", new UserUpdateController());
		mappings.put("/userInsert.do", new UserInsertController());
		mappings.put("/userDelete.do", new UserDeleteController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}