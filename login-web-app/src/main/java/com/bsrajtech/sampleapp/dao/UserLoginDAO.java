package com.bsrajtech.sampleapp.dao;

import com.bsrajtech.sampleapp.dto.UserDTO;

public interface UserLoginDAO {

	UserDTO checkUserCreds(String username);

	void updateWrongPwdCount(String username);

	void resetWrongPwdCount(String username);

	void lockUser(String username);
}
