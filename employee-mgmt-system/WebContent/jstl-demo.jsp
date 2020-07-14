<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.assimilate.ems.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%-- 	<c:out value="Welcome to assimilate" /> --%>

	<%-- 	<c:import var="data" url="https://www.javatpoint.com" /> --%>
	<c:out value="${data}" />

	<c:set var="age" scope="session" value="30"></c:set>

	Age:
	<c:out value="${age}"></c:out>

	<%-- 	<c:remove var="age"/> <br> --%>

	Age:
	<c:out value="${age}"></c:out>

	<c:if test="${age > 18 }">
		<p>
			Age is greater than 18:
			<c:out value="${age}" />
		<p>
	</c:if>

	<c:if test="${age > 50 }">
		<p>
			Age is greater than 50:
			<c:out value="${age}" />
		<p>
	</c:if>


	<br>
	<c:set var="income" scope="session" value="${500*4}" />
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
	<br>



	<c:forEach var="j" begin="1" end="5">
		<c:out value="${j}"></c:out>
	</c:forEach>

	<br>

	<%
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Tejpal");
		emp.setAge("23");

		session.setAttribute("emp", emp);

		List<Employee> emps = new ArrayList();
		emps.add(emp);
		emps.add(emp);
		emps.add(emp);

		pageContext.setAttribute("empList", emps);
	%>
	<br>
	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Action</th>

		</tr>

		<c:forEach var="employee" items="${empList}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.age}</td>
				<td><a href="DeleteEmployeeServlet?id=${emp.id}">Delete</a></td>
				<td><a href="EditEmployeeServlet?id=${emp.id}">Edit</a></td>
			</tr>
		</c:forEach>


	</table>

	<br>
	<c:forTokens items="Rahul:Nakul:Rajesh" delims=":" var="name">
		<c:out value="${name}" />
		<br>
		<p>
	</c:forTokens>


	<c:url value="welcome.jsp" var="completeURL">
		<c:param name="userName" value="Tejpal"></c:param>
		<c:param name="mobile" value="9879879"></c:param>
	</c:url>

	<br>
	<a href="${completeURL}">Click me</a>

	<%-- 	<c:redirect url="${completeURL}"></c:redirect> --%>

	<c:set var="input" value="Welcome to India" />

	<c:if test="${fn:contains(input, 'javatpoint')}">
		<p>Found javatpoint string
		<p>
	</c:if>

	<c:if test="${fn:contains(input, 'JAVATPOINT')}">
		<p>Found JAVATPOINT string
		<p>
	</c:if>

	<c:set var="vegetable">  
		<vegetables>  
		    <vegetable>  
		      <name>onion</name>  
		      <price>40/kg</price>  
		    </vegetable>  
			 <vegetable>  
			      <name>Potato</name>  
			      <price>30/kg</price>  
			    </vegetable>  
			 <vegetable>  
		      <name>Tomato</name>  
		      <price>90/kg</price>  
		    </vegetable>  
		</vegetables>  
	</c:set>  
<x:parse xml="${vegetable}" var="output"/>  

<b>Name of the vegetable is</b>:  
<x:out select="$output/vegetables/vegetable[1]/name" /><br>  

<b>Price of the Potato is</b>:  
<x:out select="$output/vegetables/vegetable[2]/price" /> 

<x:out select="$output/vegetables/vegetable[3]/name" /> 
<br>


<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/java_feb"  
     user="tejpal"  password="tejpal"/>  

<sql:query dataSource="${db}" var="rs">  
		SELECT * from employee;  
</sql:query> 

<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Action</th>

		</tr>

		<c:forEach var="employee" items="${rs.rows}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.age}</td>
				<td><a href="DeleteEmployeeServlet?id=${emp.id}">Delete</a></td>
				<td><a href="EditEmployeeServlet?id=${emp.id}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>