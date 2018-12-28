<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="employeeService"
		class="com.assimilate.loginapp.services.EmployeeService"></jsp:useBean>

	<c:set var="employees" value="${employeeService.employees}"></c:set>

	<c:set var="companyName" value="Assimilate" scope="session" />


	Welcome to
	<c:out value="${companyName}"></c:out>
	<br>
<%-- 	<c:out value="${employees}"></c:out> --%>

Employees working at <c:out value="${companyName}"></c:out>
<br>
<a href="register-employee.jsp" >Add Employee</a>
<br>
	<table border="1" align="center">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Salay</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>


		<c:forEach var="employee" items="${employees}">

<%-- 			<c:if test="${employee.salary gt 10000}"> --%>
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.name}</td>
					<td>${employee.salary}</td>
					<td>${employee.department}</td>
					<td><a href="/LoginApplication/DeleteEmployeeServlet?employeeId=${employee.employeeId}" >Delete</a>|
					<a href="/LoginApplication/EditEmployeeServlet?employeeId=${employee.employeeId}" >Edit</a></td>
				</tr>

<%-- 			</c:if> --%>


		</c:forEach>

	</table>


</body>
</html>