<%@page import="com.assimilate.sms.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.assimilate.sms.dao.StudentDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="link.html"></jsp:include>
	<%
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAllStudent();

		pageContext.setAttribute("students", students);
	%>


	<table border="1">
		<tr>
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Mobile</th>
			<th>Roll no</th>
			<th>Email</th>
			<th colspan="2"> Action</th>
		</tr>



		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.mobile}</td>
				<td>${student.rollNo}</td>
				<td>${student.email}</td>
				<td><a href="DeleteStudent?studentId=${student.id}">Delete</a></td>
				<td><a href="editStudent.jsp?studentId=${student.id}">Update</a></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>