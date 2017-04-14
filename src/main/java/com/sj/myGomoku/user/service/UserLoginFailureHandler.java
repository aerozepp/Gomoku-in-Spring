package com.sj.myGomoku.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException authExcp)
			throws IOException, ServletException {
		req.setAttribute("errMsg",authExcp.getMessage());
		req.getRequestDispatcher("/WEB-INF/views/user/loginPage.jsp").forward(req, res);		
	}

}
