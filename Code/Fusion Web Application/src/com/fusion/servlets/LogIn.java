package com.fusion.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

/**
 * Servlet implementation class LogIn
 */
//@WebServlet("/login.jsp")
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(reg_id.isEmpty()){
			/*
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			*/
			
			response.sendRedirect("/Fusion_Web_Application/login.jsp");
		} else{
			// set cookies
			Cookie userCookie = new Cookie("reg_id", reg_id);
			
			//set cookie expiration times
			userCookie.setMaxAge(60);
			
			response.addCookie(userCookie);
			
			// set session
			HttpSession session = request.getSession();
			session.setAttribute("userID", reg_id);
			session.setMaxInactiveInterval(60);
			System.out.println("Set session");
	
			/*
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			*/
			
			response.sendRedirect("/Fusion_Web_Application/index.jsp");
		}
		
	}
	
	public void destroy() {
		System.out.println("LogIn Init");
	}

}
