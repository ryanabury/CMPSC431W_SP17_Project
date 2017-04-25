<%@page import="com.fusion.html.LoginPage"%>
<%@page import="com.fusion.objects.User"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="LogIn.java" method="post">
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
</form>