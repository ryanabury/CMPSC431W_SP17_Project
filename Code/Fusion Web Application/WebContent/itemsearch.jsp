<%@page import="java.util.ArrayList"%>
<%@page import="com.fusion.html.ItemSearchPage"%>
<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.PostParameters"%>
<%@page import="com.fusion.html.HomePage"%>
<%@page import="com.fusion.objects.SaleItem"%>
<%@page import="com.fusion.objects.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 

	DBHelper db = new DBHelper();

	// Get the user ID from the page parameters.
	String userID = request.getParameter(PostParameters.USER_ID);
	
	// Get the user from the DB using the user ID.
	User user = null;
	if (userID != null) {
		user = db.getUser(userID.toCharArray());
	}
	
	// Get the search parameters from the page parameters.
	String searchParameters = request.getParameter(PostParameters.SEARCH_TERMS);
	String[] params = null;
	if (searchParameters != null) {
		params = searchParameters.split("\\+");
	}
	
	// Get the search results.
	SaleItem[] searchResults = null;
	if (params != null) {
		searchResults = db.getSaleItemsFromSearchTerms(params);
	}
	
	out.println(new ItemSearchPage(user, params, searchResults).render());
	
	db.close();
	
%>