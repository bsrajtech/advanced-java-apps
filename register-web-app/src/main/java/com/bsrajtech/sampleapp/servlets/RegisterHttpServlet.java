package com.bsrajtech.sampleapp.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.bsrajtech.sampleapp.util.ResgiterValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterHttpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String[]> inputMap = request.getParameterMap();
		Set<String> paramNames = inputMap.keySet();
		for (String p : paramNames)
			System.out.println(p + "   " + request.getParameter(p));

		Map<String, String> errors = ResgiterValidationUtil.validateInput(request);
		System.out.println(errors);

		if (errors.isEmpty()) {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else {

			Set<String> errorSet = errors.keySet();
			for (String err : errorSet)
				request.setAttribute(err, errors.get(err));

			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

}
