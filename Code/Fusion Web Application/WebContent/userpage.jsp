<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.UserPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	char[] userID = ("21").toCharArray(); // Testing page for user ID 21 in db
	out.println(new UserPage(userID).render());
%>