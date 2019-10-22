<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	company name from session scope:
	<c:out value="${companyName}"></c:out>

	<br> Order Id :
	<c:out value="${param.orderId}"></c:out>



	<c:set var="income" scope="session" value="${500}" />
	<p>
		Your income is :
		<c:out value="${income}" />
	</p>
	<c:choose>
		<c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>
		<c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>

		<c:otherwise>  
       Income is undetermined...  
    </c:otherwise>
	</c:choose>
	<br> For tokens example
	<br>
	<c:forTokens items="Rahul,Nakul,Rajesh" delims="," var="name">
		<c:out value="${name}" />
		<p>
	</c:forTokens>

	<br> C:URL example
	<br>
	<c:url value="/process.jsp" var="processJspUrl">
		<c:param name="orderId" value="786" />
		<c:param name="user" value="Nakul" />
	</c:url>

	<c:out value="${processJspUrl}"></c:out>
	<br> Process.jsp
	<a href="${processJspUrl}"> Click here</a>

	<%-- <c:redirect url="/process.jsp"></c:redirect> --%>

</body>
</html>