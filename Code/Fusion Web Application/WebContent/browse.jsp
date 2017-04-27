<%@page import="com.fusion.html.PostParameters"%>
<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.BrowsePage"%>
<%@page import="com.fusion.html.BrowsePage.Sort"%>
<%@page import="com.fusion.objects.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 

	DBHelper db = null;
	Category categoryTree = null;
	String userID = new String();
	try {
		db = new DBHelper();

		// Get user ID
		if(request.getSession().getAttribute("userID") != null){
		 	userID = request.getSession().getAttribute("userID").toString();
		 	System.out.println("Session userID: " + userID);
		}
		
		// Get Category Tree
		categoryTree = db.getCategoryTree();
		
		// Get Category Filter
		String categoryFilterIdString = request.getParameter(PostParameters.CATEGORY_FILTER);
		Category filterCategory = null;
		if (categoryFilterIdString != null) {
			int categoryFilterId = Integer.parseInt(request.getParameter(PostParameters.CATEGORY_FILTER));
			filterCategory = db.getCategory(categoryFilterId);
		}
		

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