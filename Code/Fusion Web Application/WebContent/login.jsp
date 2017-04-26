<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.html.HomePage" %>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	int result = -1;

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(username == null){
		out.println(new LoginPage().render());
	}else{
		DBHelper db = new DBHelper();
		result = db.checkLogin(username,password);
		
		if(result == 0){
			User user = db.getUser(username.toCharArray());
			
			//Loads user's homepage
			out.println(new HomePage(user).render());
		}else{
			//Reloads the login page
			out.println(new LoginPage().render());
		}
	}
%>
