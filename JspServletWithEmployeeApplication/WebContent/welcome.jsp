<%@page import="com.assimilate.employeeapp.database.EmployeeDao"%>
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
		//List<Employee> employeeList = (ArrayList<Employee>) application.getAttribute("registeredUsers");
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employeeList = employeeDao.getAllEmployees();
	%>

	<p align="center">
		<b> Registered Users </b>
	</p>
	<%
		if (employeeList == null || employeeList.isEmpty()) {
	%>
	<p>Employees not available</p>
	<%
		} else {
	%>

	<table style="border: 1;" border="1" align="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Action</th>
			
		</tr>

			<%
				for (Employee employee : employeeList) {
			%>
		<tr>
			<td><%=employee.getFirstName()%></td>
			<td><%=employee.getLastName()%></td>
			<td><%=employee.getMobileNumber()%></td>
			<td><%=employee.getUserName()%></td>
			<td><%=employee.getPassword()%></td>
			<td>
				<span><a href="<%=application.getContextPath()%>/delete-employee?employeeId=<%=employee.getEmployeeId()%>">Delete</a></span>
				<span><a href="<%=application.getContextPath()%>/update-employee?employeeId=<%=employee.getEmployeeId()%>">Edit</a></span>
			</td>
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