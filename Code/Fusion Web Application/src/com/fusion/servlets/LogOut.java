package com.fusion.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public LogOut(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogOut Post");
		
		// remove session
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(0);
		session.invalidate();
		System.out.println("Session ended");
		
		response.sendRedirect("./index.jsp");
		
	}
	
	public void destroy() {
		System.out.println("LogOut Init");
	}

}
