<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.PostParameters"%>
<%@page import="com.fusion.html.HomePage"%>
<%@page import="com.fusion.objects.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 

	// Get the user ID from the page parameters.
	String userID = request.getParameter(PostParameters.USER_ID);
	
	if (userID == null) {
		
		// Render the page.
		out.println(new HomePage().render());
		
	} else {
		
		// Get the user from the DB using the user ID.
		DBHelper db = new DBHelper();
		User user = db.getUser(userID.toCharArray());

		// Render the page.
		out.println(new HomePage(user).render());
		
	}
	
%>

<!-- replace "href=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F" with link to our homepage -->

<p style="text-align:center">
<iframe src="https://www.facebook.com/plugins/share_button.php?href=https%3A%2F%2Fwww.google.com&layout=button_count&size=small&mobile_iframe=true&width=86&height=20&appId" width="86" height="20" style="border:none;overflow:hidden;padding:2px" scrolling="no" frameborder="0" allowTransparency="true"></iframe>
</p>