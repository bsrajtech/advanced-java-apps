package com.bsrajtech.sampleapp.util;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class LoginValidationUtil {

	public static Map<String, String> validateInput(HttpServletRequest req) {
		Map<String, String> errors = new HashMap<String, String>();

		String username = req.getParameter("username");
		String secretkey = req.getParameter("secretkey");

		if (null == username || username.trim().equals("")) {
			errors.put("errUsername", "Username should not be empty");
		} else if (username.length() < 5)
			errors.put("errUsername", "Username should have min 5 chars");
		else if (username.length() > 32)
			errors.put("errUsername", "Username should not have more than 32  chars");

		if (null == secretkey || secretkey.trim().equals("")) {
			errors.put("errSecretkey", "Password should not be empty");
		} else if (secretkey.length() < 8)
			errors.put("errSecretkey", "Password should have min 8 chars");
		else if (secretkey.length() > 50)
			errors.put("errSecretkey", "Password should not have more than 50  chars");

		return errors;
	}
}
