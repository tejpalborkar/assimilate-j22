<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.assimilate.loginapp.model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>

<body>

	Welcome to Assimilate
	<br />

	<%-- 	<jsp:include page="users.jsp"></jsp:include> --%>

<%-- 		<jsp:forward page="hello.jsp">
			<jsp:param value="Tejpal Borkar" name="userName"/>
		
		</jsp:forward> 
 --%>
	<jsp:useBean id="userBean" class="com.assimilate.loginapp.model.User"
		scope="page">
		<jsp:setProperty property="firstName" name="userBean" value="Tejpal" />
		<jsp:setProperty property="lastName" name="userBean" value="Borkar" />
		<jsp:setProperty property="mobileNumber" name="userBean" value="9096876554" />

	</jsp:useBean>
 Sample Bean: <%=userBean %>

User details from userBean <br>
First Name : <jsp:getProperty property="firstName" name="userBean"/><br>
Last Name : <jsp:getProperty property="lastName" name="userBean"/><br>
Mobile :  <jsp:getProperty property="mobileNumber" name="userBean"/><br>

<br>
<a href="users.jsp">List users </a>

<br>
<a href="employees.jsp">List Employees </a>

<br>
<a href="register-employee.jsp">Add employee </a>

</body>