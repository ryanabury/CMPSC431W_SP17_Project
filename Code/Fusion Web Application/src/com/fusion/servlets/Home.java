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

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Home Init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Home Destroy");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Home Service");
		
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
		
		if(!reg_id.isEmpty()){
			// set cookies
			Cookie userCookie = new Cookie("reg_id", reg_id);
			
			//set cookie expiration times
			userCookie.setMaxAge(60);
			
			response.addCookie(userCookie);
	
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Home Post");
		
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
		
		if(!reg_id.isEmpty()){
			// set cookies
			Cookie userCookie = new Cookie("reg_id", reg_id);
			
			//set cookie expiration times
			userCookie.setMaxAge(60);
			
			response.addCookie(userCookie);
	
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
