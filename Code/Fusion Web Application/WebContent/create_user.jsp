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
<form method="POST" action="create_user.jsp">
<table align="center" border="0" width="300">
	<thead>
		<tr>
			<th>Create account</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td> First name: </td>
			<td><input type="text" name="first_name" size="30"></td>
		</tr>
		<tr>
			<td> Last name: </td>
			<td><input type="text" name="last_name" size="30"></td>
		</tr>
		<tr>
			<td> Username: </td>
			<td><input type="text" name="username" size="30"></td>
		</tr>
		<tr>
			<td> Email: </td>
			<td><input type="text" name="email" size="30"></td>
		</tr>
		<tr>
			<td> Password: </td>
			<td><input type="password" name="password" size="30"></td>
		</tr>
		<tr>
			<td> Age: </td>
			<td><input type="text" name="age" size="30"></td>
		</tr>
		<tr>
			<td> Phone number: </td>
			<td><input type="text" name="phone_num" size="30"></td>
		</tr>
		<tr>
			<td> Gender: </td>
			<td><input type="text" name="gender" size="30"></td>
		<tr>
			<td> Annual salary: </td>
			<td><input type="text" name="annual_salary" size="30"></td>	
		</tr>
		<tr>
			<td align = "center"><input type="submit" value="Create your Fusion account" name="create"></td>
		</tr>
			
	</tbody>
</table>
<%
	String first_name = request.getParameter("first_name");
	String last_name = request.getParameter("last_name");
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String phone_num = request.getParameter("phone_num");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String annual_salary = request.getParameter("annual_salary");
	
	
	
	String connectionURL = "jdbc:mysql://localhost:3306/fusion";
	
	Connection connection = null;
	
	PreparedStatement pstatement = null;
	
	Class.forName("com.mysql.jdbc.Driver").newInstance();
		int updateQuery = 0;
		
		if(first_name != null && last_name != null && username != null && email != null && password != null && phone_num != null && age != null && gender != null && annual_salary != null){
			if(first_name != "" && last_name != "" && username != "" && email != "" && password != "" && phone_num != "" && age != "" && gender != "" && annual_salary != ""){
				try{
					connection = DriverManager.getConnection(connectionURL, "root", "sentence429&pattern&yes&"); /**** CHANGE PASSWORD TO YOUR LOCAL PASSWORD ****/ 
					String queryString = "INSERT INTO fusion.users (reg_id, email, active, username, first_name, last_name, password, age, phone_num, gender, annual_salary) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					
					pstatement = connection.prepareStatement(queryString);
					pstatement.setString(1,"500");
					pstatement.setString(2,email);
					pstatement.setInt(3,1);
					pstatement.setString(4,username);
					pstatement.setString(5,first_name);
					pstatement.setString(6,last_name);
					pstatement.setString(7,password);
					pstatement.setString(8,age);
					pstatement.setString(9,phone_num);
					pstatement.setString(10,gender);
					pstatement.setString(11,annual_salary);
					updateQuery = pstatement.executeUpdate();
					if (updateQuery != 0) { %>
						<br>
						<Table style="background-color: #E3E4FA;" align="center"
						WIDTH="30%" border="1">
							<tr><th>The user was successfully created</th></tr>
						</Table>
					<%
						Thread.sleep(5000);
						String site = new String("http://localhost:8080/Fusion_Web_Application/getUserInformation.jsp"); /* TODO: Change redirect location to login page, prompt user to login */
						response.setStatus(response.SC_MOVED_TEMPORARILY);
						response.setHeader("Location", site);
					}
					pstatement.close();
					connection.close();
				}
				catch (Exception ex) {
					out.println("Unable to connect to the database.");
					ex.printStackTrace();
				}
			}
		}
%>		

</form>
<body>

</body>
</html>