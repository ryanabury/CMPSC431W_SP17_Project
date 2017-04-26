<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.html.CreateUserPage" %>
<%@page import="com.fusion.objects.User"%>
<%@page import="com.fusion.objects.PhoneNumber"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	int result = -1;	

	String first_name = request.getParameter("first_name");
	String last_name = request.getParameter("last_name");
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String age = request.getParameter("age");
	String phone_num = request.getParameter("phone_num");
	String gender = request.getParameter("gender");
	String annual_salary = request.getParameter("annual_salary");
	
	if(first_name == null){
		out.println(new CreateUserPage().render());
	}else{
		DBHelper db = new DBHelper();
		
		result = db.setCreateUser(first_name,last_name,username,email,password,age,phone_num,gender,annual_salary);
		
		if(result == 0){
			out.println(new LoginPage().render());
		}
	}
	
%>		
