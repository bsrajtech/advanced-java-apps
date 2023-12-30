package com.bsrajtech.sampleapp.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import com.bsrajtech.sampleapp.dao.UserLoginDAO;
import com.bsrajtech.sampleapp.dto.UserDTO;

public class UserLoginDAOImpl implements UserLoginDAO {

	private static ConcurrentHashMap<String, UserDTO> users = new ConcurrentHashMap<String, UserDTO>();

	{
		UserDTO user1 = new UserDTO();
		user1.setUsername("bsrajtech1");
		user1.setPasswd("Test@2024");
		user1.setGender("M");
		user1.setLocked(false);
		user1.setBirthDate(LocalDate.of(1991, 3, 9));
		user1.setPwdLastChangedDateTime(LocalDateTime.of(2023, 3, 9, 1, 1, 1));
		users.put(user1.getUsername(), user1);

		UserDTO user2 = new UserDTO();
		user2.setUsername("bsrajtech2");
		user2.setPasswd("Test@2024");
		user2.setGender("M");
		user2.setLocked(true);
		user2.setBirthDate(LocalDate.of(1991, 3, 9));
		user2.setPwdLastChangedDateTime(LocalDateTime.of(2023, 3, 9, 1, 1, 1));
		users.put(user2.getUsername(), user2);

		UserDTO user3 = new UserDTO();
		user3.setUsername("bsrajtech3");
		user3.setPasswd("Test@2024");
		user3.setGender("M");
		user3.setLocked(false);
		user3.setBirthDate(LocalDate.of(1991, 3, 9));
		user3.setPwdLastChangedDateTime(LocalDateTime.of(2000, 3, 9, 1, 1, 1));
		users.put(user3.getUsername(), user3);

		UserDTO user4 = new UserDTO();
		user4.setUsername("bsrajtech4");
		user4.setPasswd("Test@2024");
		user4.setGender("M");
		user4.setLocked(false);
		user4.setBirthDate(LocalDate.of(1991, 3, 9));
		user4.setPwdLastChangedDateTime(LocalDateTime.of(2023, 3, 9, 1, 1, 1));
		users.put(user4.getUsername(), user4);

	}

	@Override
	public UserDTO checkUserCreds(String username) {
		return users.get(username);
	}

	@Override
	public void updateWrongPwdCount(String username) {
		UserDTO dto = users.get(username);
		dto.setPwdWrongCount(dto.getPwdWrongCount() + 1);
	}

	@Override
	public void lockUser(String username) {
		UserDTO dto = users.get(username);
		dto.setLocked(true);
	}

	@Override
	public void resetWrongPwdCount(String username) {
		UserDTO dto = users.get(username);
		dto.setPwdWrongCount(0);
	}

}
