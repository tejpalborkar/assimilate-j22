<%@page import="com.assimilate.employeeapp.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%

Employee employee = (Employee) request.getAttribute("employee");
if(employee == null){
	//request for create employee
	
}else{
	//request for update employee
}

%>
<body>
	<form name="register-employeeform" method="post"
		action="<%=application.getContextPath()%>/register-employee">
		
		<input type="hidden" name="employeeId" value="<%=employee.getEmployeeId() %>" />
		
		<table width="20%" bgcolor="0099CC" align="center">

			<tr>
				<td colspan=2><center>
						<font size=4><b>Register Employee</b></font>
					</center></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" size=25 name="firstName" value="${employee.firstName}"></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" size=25 name="lastName" value="${employee.lastName}"></td>
			</tr>

			<tr>
				<td>Mobile Number</td>
				<td><input type="text" size=25 name="mobileNumber" value="${employee.mobileNumber}"></td>
			</tr>

			<tr>
				<td>Username:</td>
				<td><input type="text" size=25 name="userName" value="${employee.userName}"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="Password" size=25 name="password" value="${employee.password}"></td>
			</tr>

			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>