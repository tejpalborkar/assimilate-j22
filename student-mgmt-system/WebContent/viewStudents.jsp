<%@page import="com.assimilate.sms.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	User user = (User)session.getAttribute("loggedInUser");
	if(user == null){
		response.sendRedirect("login.jsp");	
	}
%>

	<table border=1>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>Role No</th>
			<th>Course</th>
			<th>Action</th>

		</tr>

		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.mobile}</td>
				<td>${student.rollNo}</td>
				<td>${student.course}</td>
				<td><a href="DeleteStudentServlet?id=${student.id}">Delete</a></td>
				<td><a href="EditStudentServlet?id=${student.id}">Edit</a></td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>
