<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit employee</title>
</head>
<body>
	<form action="/LoginApplication/EditEmployeeServlet" method="POST">
		<input type="hidden" size=25 name="employeeId"
			value="${employee.employeeId}">
		<table width="20%" bgcolor="0099CC" align="center">

			<tr>
				<td colspan=2><center>
						<font size=4><b>Edit employee details</b></font>
					</center></td>
			</tr>


			<tr>
				<td>Name</td>
				<td><input type="text" size=25 name="name"
					value="${employee.name}"></td>
			</tr>


			<tr>
				<td>Salary</td>
				<td><input type="text" size=25 name="salary"
					value="${employee.salary}"></td>
			</tr>


			<tr>
				<td>Department</td>
				<td><input type="text" size=25 name="department"
					value="${employee.department}"></td>
			</tr>
			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" value="Update"></td>
			</tr>

		</table>
	</form>
</body>
</html>