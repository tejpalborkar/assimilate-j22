<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.assimilate.ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <br> Welcome user from session, <%=session.getAttribute("loggedIUser")%> --%>
	<br> Welcome user from session, ${loggedIUser}

	<br> User from request param, ${param.userName}
	<br>

	<br> Password from request param, ${param.password}
	<%-- 	<br> All the parameters from the request, ${paramValues} --%>
	<%-- 	<br> All the headers from the request, ${headerValues} --%>
	<br> Init param demo :${initParam.paramName}


	<h1>First JSP</h1>
	<%
		Cookie ck = new Cookie("name", "abhishek");
		response.addCookie(ck);
	%>
	<a href="process.jsp">click</a>

	<br> Compare 2 objects 10 < 20 : ${ 10 lt 20 }
	<br> 10 < 20 : ${ 10 gt 20 }
	<br> 10 equals 10 : ${ 10 eq 10 }
	<br> 10 * 10 : ${ 10 * 10 }
	<br> 100 divide 5 : ${ 100 / 5 }
	<br> 100 + 200 : ${ 100 + 200 }
	<br>

	<%
		Employee emp = new Employee();
		emp.setFirstName("Tejpal");
		emp.setId(100);
		emp.setMobile("9879879");

		session.setAttribute("emp", emp);

		List<Employee> emps = new ArrayList();
		emps.add(emp);
		emps.add(emp);
		emps.add(emp);
	%>

	<br> Employee name : ${emp.firstName}
	<br> Employee id : ${emp.id}
	<br> Employee mobile : ${emp.mobile}
	<br>

	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Mobile</th>
		</tr>

		<%
			for (Employee emp1 : emps) {
				%> 
				<tr>
						<td><%=emp1.getId() %></td>
						<td><%=emp1.getFirstName() %></td>
						<td><%=emp1.getMobile() %></td>
				<tr>
				
				<%
			}
		%>
		
	</table>

</body>
</html>