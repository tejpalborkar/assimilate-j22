<%@page import="com.assimilate.loginapp.model.User"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<%
		int a = 100;
		int b= 200;
		
		int result = a+b;
		System.out.println(" a + b = "+result)	;
// 		PrintWriter printWriter = response.getWriter();
// 		printWriter.write(" a + b = "+result);

		out.write(" a + b = "+result);
		
		user.setFirstName("Tejpal");
		user.setLastName("Borkar");
		user.setMobileNumber("123123");
		
	%>
	<%!
	int i =100;
	String str = "Tejpal Borkar Assimilate";
	User user = new User();
	
	%>

	<br> Message from expression tag
	<br> Welcome,<%=user.getFirstName()+" "+user.getLastName()%>

	<br> Mobile number:
	<%=user.getMobileNumber() %>

	<br> Welcome to assimilate. (hello.jsp)


	<%

	String userName  = request.getParameter("userName");
		
		out.println("<br>Welcome, "+userName);

%>


</body>
</html>