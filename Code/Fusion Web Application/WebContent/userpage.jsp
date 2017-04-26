<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.UserPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// Get session userID
	String userID = new String();
	if(request.getSession().getAttribute("userID") != null){
		 userID = request.getSession().getAttribute("userID").toString();
		 System.out.println("Session userID: " + userID);
	}
	
	if (userID.isEmpty()) {
		
		out.println("userID is empty");
		
	} else {
		
		System.out.println("userID is not empty");
	
		// Render the page.
		out.println(new UserPage(userID.toCharArray()).render());
		
	}
%>
