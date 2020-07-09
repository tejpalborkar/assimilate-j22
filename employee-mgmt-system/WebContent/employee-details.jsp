<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="empBean" class="com.assimilate.ems.Employee"
		scope="application"></jsp:useBean>

	<br> Employee name from userBean : Name:
	<jsp:getProperty property="name" name="empBean" />
	<br> Mobile
	<jsp:getProperty property="mobile" name="empBean" />
	<br> UserId
	<jsp:getProperty property="userId" name="empBean" />
	<br> Name
	<jsp:getProperty property="firstName" name="empBean" />
	<br>
	
	<%
	
		String firstname= empBean.getFirstName();
	%>

</body>
</html>