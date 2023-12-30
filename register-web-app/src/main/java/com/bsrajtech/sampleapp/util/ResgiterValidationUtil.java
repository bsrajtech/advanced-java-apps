package com.bsrajtech.sampleapp.util;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletRequest;

public class ResgiterValidationUtil {

	public static Map<String, String> validateInput(ServletRequest req) {
		Map<String, String> errors = new HashMap<String, String>();

		String username = req.getParameter("username");
		String secretkey1 = req.getParameter("secretkey1");
		String secretkey2 = req.getParameter("secretkey2");

		if (null == username || username.trim().equals("")) {
			errors.put("register.username", "Username should not be empty");
		} else if (username.length() < 5)
			errors.put("register.username", "Username should have min 5 chars");
		else if (username.length() > 32)
			errors.put("register.username", "Username should not have more than 32  chars");

		if (null == secretkey1 || secretkey1.trim().equals("")) {
			errors.put("register.secretkey1", "Password should not be empty");
		} else if (secretkey1.length() < 8)
			errors.put("register.secretkey1", "Password should have min 8 chars");
		else if (secretkey1.length() > 50)
			errors.put("register.secretkey1", "Password should not have more than 50  chars");

		if (null == secretkey2 || secretkey2.trim().equals("")) {
			errors.put("register.secretkey2", "Password should not be empty");
		} else if (secretkey2.length() < 8)
			errors.put("register.secretkey2", "Password should have min 8 chars");
		else if (secretkey2.length() > 50)
			errors.put("register.secretkey2", "Password should not have more than 50  chars");

		if (null != secretkey2 && !secretkey2.equals(secretkey1))
			errors.put("register.message", "Both passwords didnt match");

		return errors;
	}
}
