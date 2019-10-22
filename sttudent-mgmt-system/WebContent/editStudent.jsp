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
	String studentId = request.getParameter("studentId");
	StudentDao dao = new StudentDao();
	Student student = dao.getStudentById(Integer.parseInt(studentId));
	pageContext.setAttribute("studentDetails", student);
%>
	<form action="UpdateStudentServlet" method="POST">
		<input type="hidden" size=25 name="id"
			value="${studentDetails.id}">
		<table width="20%" bgcolor="0099CC" >

			
			<tr>
				<td colspan=2><center>
						<font size=4><b>Edit Student details</b></font>
					</center></td>
			</tr>


			<tr>
				<td>Name</td>
				<td><input type="text" size=25 name="name" value="${studentDetails.name}"></td>
			</tr>


			<tr>
				<td>Mobile</td>
				<td><input type="text" size=25 name="mobile" value="${studentDetails.mobile}"></td>
			</tr>

			<tr>
				<td>Roll Number</td>
				<td><input type="text" size=25 name="rollNumber" value="${studentDetails.rollNo}"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" size=25 name="email" value="${studentDetails.email}"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" size=25 name="password" value="${studentDetails.password}"></td>
			</tr>
			
			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>