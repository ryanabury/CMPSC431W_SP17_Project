<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.PostParameters"%>
<%@page import="com.fusion.html.SaleReportPage"%>
<%@page import="com.fusion.objects.SaleTransaction" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	DBHelper db = new DBHelper();
	
	ArrayList<SaleTransaction> item_list = db.getTransactionReport();
	
	out.println("<p>" + item_list + "</p>");

	out.println(new SaleReportPage(item_list).render());
	
%>