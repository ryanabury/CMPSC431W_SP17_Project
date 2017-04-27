<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.BrowsePage"%>
<%@page import="com.fusion.html.BrowsePage.Sort"%>
<%@page import="com.fusion.objects.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	String userID = new String();
	if(request.getSession().getAttribute("userID") != null){
	 	userID = request.getSession().getAttribute("userID").toString();
	 	System.out.println("Session userID: " + userID);
	}
	
	DBHelper db = null;
	Category categoryTree = null;
	try {
		db = new DBHelper();
		categoryTree = db.getCategoryTree();
	} finally {
		if (db != null) {
			db.close();
		}
	}

	out.println(
			new BrowsePage(
					userID.toCharArray(), 
					Sort.ALPHABETICAL_DESCENDING, 
					categoryTree,0
			).render()
	);
	
%>