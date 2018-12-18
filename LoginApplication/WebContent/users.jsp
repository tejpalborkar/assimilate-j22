<%@page import="java.util.List"%>
<%@page import="com.assimilate.loginapp.services.UserService"%>
<%@page import="com.assimilate.loginapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!--

jsp:setProperty ->  We can set some variable with some initial value. name -> value
jsp:getProperty -> to retrieve  the value 


-->
	<%!User userFromPageContext = null;%>

	<jsp:useBean id="userService"
		class="com.assimilate.loginapp.services.UserService"></jsp:useBean>

	<%
	
		User user = userService.getUser();
		pageContext.setAttribute("user", user);

		// 		request.getAttribute("")
		// 		request.getParameter("");

		// 		response.sendRedirect("hello.jsp");
		// config.getInitParameter("");

		// application.getContextPath()

		// 		out.println("Context path:" + application.getContextPath());

		User userFromSession = (User) session.getAttribute("loggedInuser");

		// 		out.println("<br>User from session: "+userFromSession);
	%>


	<%
		userFromPageContext = (User) pageContext.getAttribute("user");
	
	
	List<User> users = userService.getUsers();	
	%>
	Registered users.
	<table border="1" align="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Number</th>
		</tr>

		<%
			for (User usr : users) {
		%>
		<tr>

			<td><%=usr.getFirstName()%></td>
			<td><%=usr.getLastName()%></td>
			<td><%=usr.getMobileNumber()%></td>

		</tr>
		<%
			}
		%>


	</table>
</body>
</html>