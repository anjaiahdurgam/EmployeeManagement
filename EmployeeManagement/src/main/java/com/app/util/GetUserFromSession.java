package com.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetUserFromSession {

	public static void setUser(HttpServletRequest request, Object obj) {
		HttpSession session = request.getSession();
		session.setAttribute("user", obj);

	}

	public static Object getUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session.getAttribute("user");
	}

}
