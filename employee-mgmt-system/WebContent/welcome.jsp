<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page errorPage="error.jsp" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("query");

		//PrintWriter writer = response.getWriter();

		out.write("Welcome, " + username);

		//	response.sendRedirect("https://www.google.com/search?sxsrf=ALeKk00HCLJA5YB4cK_PBfmzfCVUWpB65A%3A1594100268536&source=hp&ei=LAoEX4jYHraL4-EP5f2LgAE&q="+username+"&oq=&gs_lcp=CgZwc3ktYWIQARgAMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnMgcIIxDqAhAnUABYAGCXGWgBcAB4AIABAIgBAJIBAJgBAKoBB2d3cy13aXqwAQo&sclient=psy-ab");

		String paramValue = config.getInitParameter("paramName");

		session.setAttribute("loggedIUser", username);

		application.setAttribute("companyName", "Assimilate Technology");

		HttpServlet servlet = (HttpServlet) page;


			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
			requestDispatcher.forward(request, response);

		pageContext.setAttribute("actor", "Salman Khan", PageContext.SESSION_SCOPE);

		//	response.sendRedirect("http://localhost:8080/employee-mgmt-system/user.jsp");
	%>
	<br> Actor from pageContext,
	<%=pageContext.getAttribute("actor", PageContext.SESSION_SCOPE)%>
</body>
</html>