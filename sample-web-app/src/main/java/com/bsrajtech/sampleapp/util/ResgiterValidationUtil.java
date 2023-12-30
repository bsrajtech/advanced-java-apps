package com.bsrajtech.sampleapp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletRequest;

public class ResgiterValidationUtil {

	private static final Set<String> genderSet = Set.of("male", "female", "other");
	private static final Set<String> courses = Set.of("Java FullStack", "Python FullStack", "UI FullStack", "Database",
			"DevOps");

	public static Map<String, String> validateInput(ServletRequest req) {
		Map<String, String> errors = new HashMap<String, String>();

		String username = req.getParameter("username");
		String secretkey1 = req.getParameter("secretkey1");
		String secretkey2 = req.getParameter("secretkey2");

		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");

		if (null == username || username.trim().equals("")) {
			errors.put("errUsername", "Username should not be empty");
		} else if (username.length() < 5)
			errors.put("errUsername", "Username should have min 5 chars");
		else if (username.length() > 32)
			errors.put("errUsername", "Username should not have more than 32  chars");

		if (null == secretkey1 || secretkey1.trim().equals("")) {
			errors.put("errSecretkey1", "Password should not be empty");
		} else if (secretkey1.length() < 8)
			errors.put("errSecretkey1", "Password should have min 8 chars");
		else if (secretkey1.length() > 50)
			errors.put("errSecretkey1", "Password should not have more than 50  chars");

		if (null == secretkey2 || secretkey2.trim().equals("")) {
			errors.put("errSecretkey2", "Password should not be empty");
		} else if (secretkey2.length() < 8)
			errors.put("errSecretkey2", "Password should have min 8 chars");
		else if (secretkey2.length() > 50)
			errors.put("errSecretkey2", "Password should not have more than 50  chars");

		if (null == course || course.trim().equals("")) {
			errors.put("errCourse", "course should not be empty");
		} else {
			if (!courses.contains(course))
				errors.put("errCourse", "Please select a course");
		}

		if (null == dob || dob.trim().equals("")) {
			errors.put("errdob", "errdob should not be empty");
		} else {

		}

		if (null == gender || gender.trim().equals("")) {
			errors.put("errGender", "Gender should not be empty");
		} else {
			if (!genderSet.contains(gender))
				errors.put("errGender", "Please select a gender");
		}

		if (null != secretkey2 && !secretkey2.equals(secretkey1))
			errors.put("errRegister", "Both passwords didnt match");

		return errors;
	}
}
