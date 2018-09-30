<%@page import="java.util.ArrayList"%>
<%@page import="com.assimilate.employeeapp.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
<center><a  href="<%=application.getContextPath()%>/register-employee.jsp">Add User</a></center>
	<%
		List<Employee> employeeList = (ArrayList<Employee>) application.getAttribute("registeredUsers");
	%>

	<p align="center">
		<b> Registered Users </b>
	</p>
	<%
		if (employeeList == null) {
	%>
	<p>not available</p>
	<%
		} else {
	%>

	<table style="border: 1;" border="1" align="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Password</th>
		</tr>

			<%
				for (Employee employee : employeeList) {
			%>
		<tr>
			<td><%=employee.getFirstName()%></td>
			<td><%=employee.getLastName()%></td>
			<td><%=employee.getUserName()%></td>
			<td><%=employee.getPassword()%></td>
		</tr>
			<%
				}
			%>
	</table>

	<%
		}
	%>



</body>
</html>