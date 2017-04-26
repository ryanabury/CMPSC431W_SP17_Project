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

public class Home extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Home Init");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Home Service");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		// get reg_id
		String reg_id = new String();
		try {
			DBHelper db = new DBHelper();
			reg_id = db.getUserID(username, password);
			
		} catch (DBHelperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!reg_id.isEmpty()){
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
		}
	}
	
	public void destroy() {
		System.out.println("Home Destroy");
	}

}
