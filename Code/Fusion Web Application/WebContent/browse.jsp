<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.AboutPage"%>
<%@page import="com.fusion.objects.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	String userID = new String();
	if(request.getSession().getAttribute("userID") != null){
	 	userID = request.getSession().getAttribute("userID").toString();
	 	System.out.println("Session userID: " + userID);
	}

	out.println(new BrowsePage(userID.toCharArray()).render());
	
%>