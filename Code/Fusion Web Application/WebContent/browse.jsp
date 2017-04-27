<%@page import="java.util.Comparator"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<SaleItem> saleItems = new ArrayList<>();
	Sort sort = Sort.ALPHABETICAL_DESCENDING;
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
		
		// Get all Sale Items
		if (filterCategory == null) {
			saleItems = db.getAllSaleItems();
		} else {
			saleItems = db.getSaleItemByCategory(filterCategory);
		}
		
		// Get Sort
		String sortParameterString = request.getParameter(PostParameters.SORT);
		if (sortParameterString != null) {
			int sortInteger = Integer.parseInt(sortParameterString);
			sort = Sort.valueOf(sortInteger);
		}
		
		switch (sort) {
			case ALPHABETICAL_ASCENDING:
				saleItems.sort(new Comparator<SaleItem>() {
					public int compare(SaleItem o1, SaleItem o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
			case ALPHABETICAL_DESCENDING:
				saleItems.sort(new Comparator<SaleItem>() {
					public int compare(SaleItem o1, SaleItem o2) {
						return -o1.getName().compareTo(o2.getName());
					}
				});
			case PRICE_LOW_TO_HIGH:
				saleItems.sort(new Comparator<SaleItem>() {
					public int compare(SaleItem o1, SaleItem o2) {
						return o2.getPrice() - o1.getPrice();
					}
				});
			case PRICE_HIGH_TO_LOW:
				saleItems.sort(new Comparator<SaleItem>() {
					public int compare(SaleItem o1, SaleItem o2) {
						return o1.getPrice() - o2.getPrice();
					}
				});
		}
		

	} finally {
		if (db != null) {
			db.close();
		}
	}
	
	out.println(
			new BrowsePage(
					userID.toCharArray(), 
					sort, 
					categoryTree,0
			).render()
	);
	
%>