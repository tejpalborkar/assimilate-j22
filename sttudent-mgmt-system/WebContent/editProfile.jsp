<%@page import="com.assimilate.sms.model.Student"%>
<%@page import="com.assimilate.sms.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit employee</title>
</head>
<body>
<%
//Student object will be reffered from session

%>
<jsp:include page="link.html"></jsp:include>
	<form action="UpdateStudentServlet" method="POST">
		<input type="hidden" size=25 name="id"
			value="${student.id}">
		<table width="20%" bgcolor="0099CC">

			
			
			<tr>
				<td colspan=2><center>
						<font size=4><b>Edit Student details</b></font>
					</center></td>
			</tr>



			<tr>
				<td>Student Id</td>
				<td><input type="text" size=25 name="name" value="${student.id}" disabled="disabled"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" size=25 name="name" value="${student.name}" ></td>
			</tr>


			<tr>
				<td>Mobile</td>
				<td><input type="text" size=25 name="mobile" value="${student.mobile}" ></td>
			</tr>

			<tr>
				<td>Roll Number</td>
				<td><input type="text" size=25 name="rollNumber" value="${student.rollNo}" ></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" size=25 name="email" value="${student.email}" ></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" size=25 name="password" value="${student.password}" ></td>
			</tr>

			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>