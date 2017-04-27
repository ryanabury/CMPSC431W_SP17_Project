<%@page import="com.fusion.html.BuyItemPage" %>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	// Get session userID
	String userID = new String();
	if(request.getSession().getAttribute("userID") != null){
		userID = request.getSession().getAttribute("userID").toString();
		System.out.println("Session userID: " + userID);
	}
	
	char[] itemID = request.getParameter("item_ID").toCharArray();
	System.out.println("Purchasing item: " + new String(itemID));
	out.println(new BuyItemPage(userID.toCharArray(), itemID).render()); 
%>