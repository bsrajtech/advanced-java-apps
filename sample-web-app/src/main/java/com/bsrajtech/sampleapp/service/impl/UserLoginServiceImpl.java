package com.bsrajtech.sampleapp.service.impl;

import com.bsrajtech.sampleapp.dao.UserLoginDAO;
import com.bsrajtech.sampleapp.dao.impl.UserLoginDAOImpl;
import com.bsrajtech.sampleapp.dto.UserDTO;
import com.bsrajtech.sampleapp.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	UserLoginDAO dao;

	public UserLoginServiceImpl() {
		dao = new UserLoginDAOImpl();
	}

	@Override
	public String checkUser(String username, String pwd) {
		UserDTO userDTO = dao.checkUserCreds(username);
		if (null == userDTO)
			return "User doesnot exists";

		if (userDTO.isLocked())
			return "User has been locked";

		if (userDTO.getPwdWrongCount() >= 5) {
			return "Too many attempts";
		}

		if (!pwd.equals(userDTO.getPasswd())) {
			dao.updateWrongPwdCount(username);
			return "Wrong password";
		}

		if (userDTO.getPwdWrongCount() != 0)
			dao.resetWrongPwdCount(username);

		return "OK";
	}

}
