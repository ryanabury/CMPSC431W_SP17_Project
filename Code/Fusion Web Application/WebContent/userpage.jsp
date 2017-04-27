<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.UserPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="j2html.tags.ContainerTag" %>
<%@page import="j2html.TagCreator.*" %>

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
	
	/*
	if (userID.isEmpty()) {
		System.out.println("userID is empty");
		out.println(new UserPage().render());
		
	} else {
		
		System.out.println("userID is not empty");
		// Get the user from the DB using the user ID.
		DBHelper db = new DBHelper();
		User user = db.getUser(userID.toCharArray());
		
		// Render the page.
		out.println(new UserPage(user).render());
		
	}*/

	out.println(new UserPage(userID.toCharArray()).render());
%>
