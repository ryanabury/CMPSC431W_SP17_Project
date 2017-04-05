<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create user</title>
</head>
<form method="POST" action="getUserInformation.jsp">
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
			<td align = "center"><input type="submit" value="Login to your Fusion Account" name="create"></td>
		</tr>
			
	</tbody>
</table>
<%
	String username = request.getParameter("username");
	
	
	
	String connectionURL = "jdbc:mysql://localhost:3306/fusion";
	
	Connection connection = null;
	
	PreparedStatement pstatement = null;
	ResultSet rs = null;
	
	Class.forName("com.mysql.jdbc.Driver").newInstance();
		
	try{
		connection = DriverManager.getConnection(connectionURL, "root", "sentence429&pattern&yes&"); /**** CHANGE PASSWORD TO YOUR LOCAL PASSWORD ****/ 
		String queryString = "SELECT * FROM fusion.users WHERE username = ?";
		
		pstatement = connection.prepareStatement(queryString);
		pstatement.setString(1, username);
		
		rs = pstatement.executeQuery();
		
		while (rs.next()) {
			%><p>First Name: </p><% out.print(rs.getString("first_name"));
			%><p>Last Name: </p><% out.print(rs.getString("last_name"));
			%><p>Age: </p><% out.print(rs.getInt("age"));
			%><p>Annual Salary: </p><% out.print(rs.getInt("annual_salary"));
		}
		
		pstatement.close();
		rs.close();
		connection.close();
	}
	catch (Exception ex) {
		out.println("Unable to connect to the database.");
		ex.printStackTrace();
	}
	
%>

</form>
<body>

</body>
</html>