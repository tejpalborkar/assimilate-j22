<%@page import="com.assimilate.sms.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%

Student student = (Student) session.getAttribute("student");

if(student!=null){
// 	it will redirect to home page if student is already logged in
	response.sendRedirect("home.jsp");
}
%>

	<form action="LoginServlet" method="POST">
		<table width="20%" bgcolor="0099CC" align="center">

			<tr>
				<td colspan=2><center>
						<font size=4><b>HTML Login Page</b></font>
					</center></td>
			</tr>

			<tr>
				<td>Username:</td>
				<td><input type="text" size=25 name="userName"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="Password" size=25 name="password"></td>
			</tr>

			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" value="Login"></td>
			</tr>
			<tr>
				<td><a
					href="<%=application.getContextPath()%>/registerStudent.jsp">Register
						here</a></td>
			</tr>

		</table>
	</form>
</body>
</html>