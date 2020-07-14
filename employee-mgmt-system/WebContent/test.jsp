<%@page import="com.assimilate.ems.model.Employee"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Forward request to user.jsp.

	<%-- 	<jsp:forward page="user.jsp"></jsp:forward> --%>

	<br> Response of user.jsp included in test.jsp
	<%-- <jsp:include page="user.jsp"></jsp:include> --%>
	<%
		Employee emp = new Employee();
			emp.setName("Tejpal");
			emp.setMobile("998798");
			emp.setPassword("1234");
			emp.setUserId("tejpal");
			emp.setId(12345);
			
			application.setAttribute("empBean",emp);
			session.setAttribute("empBean",emp);
	%>


	<jsp:useBean id="empBean" class="com.assimilate.ems.model.Employee"
		scope="application">

	</jsp:useBean>
	<jsp:setProperty property="name" name="empBean" value="Tejpal B" />
	<jsp:setProperty property="mobile" name="empBean" value="87687687" />
	<jsp:setProperty property="userId" name="empBean" value="tejpal" />
	<jsp:setProperty property="firstName" name="empBean" value="Tejpal" />
	<br>

	<br> Employee name from userBean : Name:
	<jsp:getProperty property="name" name="empBean" />
	<br> Mobile
	<jsp:getProperty property="mobile" name="empBean" />
	<br> UserId
	<jsp:getProperty property="userId" name="empBean" />
	<br> Name
	<jsp:getProperty property="firstName" name="empBean" />
	<br>

	<br>




</body>
</html>