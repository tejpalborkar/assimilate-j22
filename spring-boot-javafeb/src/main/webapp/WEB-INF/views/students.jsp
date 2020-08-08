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

<a href="/students/addStudent">Add Student</a>
${message}


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
				<td><a href="/students/delete/${student.id}">Delete</a></td>
				<td><a href="/students/edit/${student.id}">Edit</a></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>