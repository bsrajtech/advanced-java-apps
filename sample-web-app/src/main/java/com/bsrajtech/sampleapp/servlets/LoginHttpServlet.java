package com.bsrajtech.sampleapp.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.bsrajtech.sampleapp.service.UserLoginService;
import com.bsrajtech.sampleapp.service.impl.UserLoginServiceImpl;
import com.bsrajtech.sampleapp.util.LoginValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginHttpServlet extends HttpServlet {

	UserLoginService service;

	public LoginHttpServlet() {
		super();
		service = new UserLoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (null != username && !username.trim().equals("")) {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errors = LoginValidationUtil.validateInput(request);

		if (errors.isEmpty()) {
			String message = service.checkUser(request.getParameter("username"), request.getParameter("secretkey"));
			if ("OK".equals(message)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", request.getParameter("username"));
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} else {
				request.setAttribute("errLogin", message);
				request.setAttribute("formUsername", request.getParameter("username"));
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			Set<String> errSet = errors.keySet();
			for (String err : errSet)
				request.setAttribute(err, errors.get(err));

			request.setAttribute("formUsername", request.getParameter("username"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
