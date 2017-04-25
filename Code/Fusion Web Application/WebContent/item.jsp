<%@page import="com.fusion.html.ItemPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	
	// Send GET request to this page in the form of "item.jsp?item_ID=*ID*" with *ID* replaced with the desired ID. 
	// Or dynamically create URL in the browsing page

	char[] itemID = request.getParameter("item_ID").toCharArray();
	// Get the user ID from the page parameters.
	
	out.println(new ItemPage(itemID).render());
	
%>