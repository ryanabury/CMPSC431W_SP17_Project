<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.html.HomePage" %>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form method="POST" action="login.jsp">
<table align="center" border="0" width="300">
	<thead>
		<tr>
			<th>Login</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td> Username: </td>
			<td><input type="text" name="username" size="30"></td>
		</tr>
		<tr>
			<td> Password: </td>
			<td><input type="password" name="password" size = "30"></td>
		<tr>
			<td align = "center"><input type="submit" value="Login" name="login"></td>
		</tr>
	</tbody>
</table>
<% 
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	String ConnectionURL = "jdbc:mysql://localhost:3306/fusion";
	
	Connection connection = null;
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	try{
		connection = DriverManager.getConnection(ConnectionURL, "root", "sentence429&pattern&yes&"); /* CHANGE TO LOCAL PASSWORD */ 
		String sql = "SELECT * FROM fusion.users WHERE username = ? AND password = ?";
		
		pst = connection.prepareStatement(sql);
		pst.setString(1,username);
		pst.setString(2,password);
		
		rs = pst.executeQuery();
		
		if(!rs.next()){
			//Refreshes page after failed login attempt
			out.println(new LoginPage().render());
			throw new DBHelper.DBHelperException("No such username [" + username + "]");
		}
		else{
			//Gets user from database with username
			DBHelper db = new DBHelper();
			User user = db.getUser(username.toCharArray());
			
			//Loads the user's homepage
			out.println(new HomePage(user).render());
		}
		
		pst.close();
		rs.close();
		connection.close();
	}
	catch (Exception ex) {
		out.println("Unable to connect to the database.");
		ex.printStackTrace();
	}
		
%>
</form>