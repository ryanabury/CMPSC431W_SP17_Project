<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.SupplierPage"%>
<%@page import="com.fusion.objects.Supplier"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	//Get session userID
	String userID = new String();
	if(request.getSession().getAttribute("userID") != null){
		 userID = request.getSession().getAttribute("userID").toString();
		 System.out.println("Session userID: " + userID);
	}	

	String suppID = request.getParameter("supplier_ID");
	if (suppID == null) {
		suppID = "1";
	}
	char[] supplier_ID = suppID.toCharArray();
	// Testing page for supplier ID 2 in db
	out.println(new SupplierPage(supplier_ID, userID.toCharArray()).render());
%>
