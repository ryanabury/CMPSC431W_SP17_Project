package com.fusion.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class LogIn extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    
	public LogIn(){
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogIn Post");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// get reg_id
		String reg_id = new String();
		try {
			DBHelper db = new DBHelper();
			reg_id = db.getUserID(username, password);
			
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
		
		if(reg_id.isEmpty()){
			// incorrect login, go back to login page
			response.sendRedirect("/Fusion_Web_Application/login.jsp");
		} else{
			
			// set session
			HttpSession session = request.getSession();
			session.setAttribute("userID", reg_id);
			session.setMaxInactiveInterval(60);
			System.out.println("Session started");
			
			response.sendRedirect("/Fusion_Web_Application/index.jsp");
		}
		
	}
	
	public void destroy() {
		System.out.println("LogIn Init");
	}

}
