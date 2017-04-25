<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="LogIn.java" method="post">
	<% out.println(new LoginPage().render()); %>
</form>