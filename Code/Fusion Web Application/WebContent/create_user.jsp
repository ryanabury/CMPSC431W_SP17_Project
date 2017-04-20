<%@page import="com.fusion.sql.DBHelper"%>
<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form method="POST" action="create_user.jsp">
<table align="center" border="0" width="300">
	<thead>
		<tr>
			<th>Create account</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td> First name: </td><%
			boolean isvalid = true;
			String first_name = request.getParameter("first_name");
			if (first_name == null){
			%>
				<td><input type="text" name="first_name" style="border:2px solid #000000"size="30"></td>
			<%}
			else if (first_name == ""){
				isvalid = false;
				%><td><input type="text" name="first_name" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="text" name="first_name" style="border:2px solid #000000"size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Last name: </td><%
			String last_name = request.getParameter("last_name");
			if (last_name == null){
			%>
				<td><input type="text" name="last_name" style="border:2px solid #000000"size="30"></td>
			<%}
			else if (last_name == ""){
				isvalid = false;
				%><td><input type="text" name="last_name" style="border:2px solid #ff0000" size="30"></td><%
			}
			else {
				%><td><input type="text" name="last_name" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Username: </td><%
			String username = request.getParameter("username");
			if (username == null){
			%>
				<td><input type="text" name="username" style="border:2px solid #000000"size="30"></td>
			<%
			}else if (username.contains(" ") || username == ""){
				isvalid = false;
				%><td><input type="text" name="username" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="text" name="username" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Email: </td><%
			String email = request.getParameter("email");
			if (email == null){
			%>
				<td><input type="text" name="email" style="border:2px solid #000000"size="30"></td>
			<%
			}else if(!email.contains("@") || email.contains("..")){
				isvalid = false;
				%><td><input type="text" name="email" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="text" name="email" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Password: </td><%
			String password = request.getParameter("password");
			if (password == null){
			%>
				<td><input type="password" name="password" style="border:2px solid #000000"size="30"></td>
			<%
			}else if(password.contains(" ") || password == ""){
				isvalid = false;
				%><td><input type="password" name="password" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="password" name="password" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Age: </td><%
			String age = request.getParameter("age");
			if (age == null){	
			%>
				<td><input type="text" name="age" style="border:2px solid #000000"size="30"></td>
			<%
			}else if(age.length() > 3 || age == ""){
				isvalid = false;
				%><td><input type="text" name="age" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="text" name="age" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Phone number: </td><%
			String phone_num = request.getParameter("phone_num");
			if (phone_num == null){
				%>
				<td><input type="text" name="phone_num" style="border:2px solid #000000"size="30"></td>
			<%
			}else if(phone_num.length() != 10 || phone_num == ""){
				isvalid = false;
				%><td><input type="text" name="phone_num" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%><td><input type="text" name="phone_num" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		</tr>
		<tr>
			<td> Gender: </td><%
			String gender = request.getParameter("gender");
			if (gender == null){
				%>
				<td><input type="text" name="gender" style="border:2px solid #000000"size="30"></td>
			<%
			}else if(!gender.equals("m") && !gender.equals("M") && !gender.equals("f") && !gender.equals("F")){
				isvalid = false;
				%><td><input type="text" name="gender" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				gender = gender.toUpperCase();
				%><td><input type="text" name="gender" style="border:2px solid #000000" size="30"></td><%
			}
			 %>
		<tr>
			<td> Annual salary: </td><%
			String annual_salary = request.getParameter("annual_salary");
			if (annual_salary == null){
			%>
				<td><input type="text" name="annual_salary" style="border:2px solid #000000"size="30"></td>
			<%}
			else if (annual_salary == ""){
				isvalid = false;
				%><td><input type="text" name="annual_salary" style="border:2px solid #ff0000" size="30"></td><%
			}
			else{
				%>
				<td><input type="text" name="annual_salary" style="border:2px solid #000000"size="30"></td>
			<%
			}
			 %>
		</tr>
		<tr>
			<td align = "center"><input type="submit" value="Create your Fusion account" name="create"></td>
		</tr>
			
	</tbody>
</table>
<%

	String ConnectionURL = "jdbc:mysql://localhost:3306/fusion";

	Connection connection = null;

	PreparedStatement pst = null;
	ResultSet rs = null;

	Class.forName("com.mysql.jdbc.Driver").newInstance();
	int updateQuery = 0;

	try{
		connection = DriverManager.getConnection(ConnectionURL, "root", "JDsdljad2340!"); /* CHANGE TO LOCAL PASSWORD */ 
		String sql = "Select U1.reg_id FROM fusion.users U1 WHERE U1.reg_id >= ALL (SELECT U2.reg_id FROM fusion.users U2)";
		
		pst = connection.prepareStatement(sql);
		rs = pst.executeQuery();
		
		int reg_id = 0;
		
		//Retrieves the max reg_id and increments by one
		while(rs.next()){
			reg_id = rs.getInt("reg_id") + 1;
		}
			
		pst.close();
		rs.close();
		connection.close();
			
		pst = null;
		rs = null;
		connection = null;
		if(!isvalid){
			%><th><font color="red">Invalid entry</font></th><%
		}
		
		if(email != null && username != null && first_name != null && last_name != null && password != null && age != null && phone_num != null && gender != null && annual_salary != null && isvalid){					
			connection = DriverManager.getConnection(ConnectionURL, "root", "JDsdljad2340!"); /* CHANGE TO LOCAL PASSWORD */ 
			sql = "INSERT INTO fusion.users (reg_id, email, active, username, first_name, last_name, password, age, phone_num, gender, annual_salary) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
						
	    	pst = connection.prepareStatement(sql);
			pst.setInt(1,reg_id);
			pst.setString(2,email);
			pst.setInt(3,1);
			pst.setString(4,username);
			pst.setString(5,first_name);
			pst.setString(6,last_name);
			pst.setString(7,password);
			pst.setString(8,age);
			pst.setString(9,phone_num);
			pst.setString(10,gender);
			pst.setString(11,annual_salary);
			updateQuery = pst.executeUpdate();
			if (updateQuery != 0) { %>
				<br>
					<Table>
					<tr><th>Congratulations! Your account has been created.</th></tr>
					</Table>
				<%
				Thread.sleep(5000);
			}
			pst.close();
			connection.close();
		}
	}
	catch (Exception ex) {
		out.println("Unable to connect to the database.");
		ex.printStackTrace();
	}

%>		

</form>