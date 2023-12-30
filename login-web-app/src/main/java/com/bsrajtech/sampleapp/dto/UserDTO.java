package com.bsrajtech.sampleapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
	private String username;
	private String passwd;

	private String gender;
	private LocalDate birthDate;
	private boolean isLocked;

	private LocalDateTime pwdLastChangedDateTime;
	private Integer pwdWrongCount;

	public UserDTO() {
		pwdWrongCount = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public LocalDateTime getPwdLastChangedDateTime() {
		return pwdLastChangedDateTime;
	}

	public void setPwdLastChangedDateTime(LocalDateTime pwdLastChangedDateTime) {
		this.pwdLastChangedDateTime = pwdLastChangedDateTime;
	}

	public Integer getPwdWrongCount() {
		return pwdWrongCount;
	}

	public void setPwdWrongCount(Integer pwdWrongCount) {
		this.pwdWrongCount = pwdWrongCount;
	}

}
