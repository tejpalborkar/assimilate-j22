<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User </title>
</head>
<body>
	Welcome to,  <%=application.getAttribute("companyName")%>
	<br> Welcome user from session, <%=session.getAttribute("loggedIUser")%>
	
	<br> Welcome user from page contexts, session, <%=session.getAttribute("actor")%>
	
	
	<br> Actor from pageContext, <%=pageContext.getAttribute("actor",PageContext.SESSION_SCOPE)%>
<br>
==============================================
Welcome Tejpal
</body>
</html>