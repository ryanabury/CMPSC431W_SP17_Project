<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.AboutPage"%>
<%@page import="com.fusion.objects.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 

	out.println(new AboutPage().render());
	
%>