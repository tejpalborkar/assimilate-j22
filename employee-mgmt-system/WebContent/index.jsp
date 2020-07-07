
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
// expression tag - <%= %>  // Used to execute the expression and return the result as  a html

// declaration -    <%! %>  // declare the variables in the jsp

// scriplet tag  	// execute your java functions/code. --%>

	Scriptlet tag example

	<%!int x = 100;

	public int addNuumbers(int a, int b) {
		return a + b;
	}%>
	<%
		int a = 100;
		int b = 200;
		int result = a + b;
		System.out.println("a + b : " + result);
	%>

	<%
		System.out.println("a + b : " + result);
	%>


	Hello world in jsp:
	<%="Tejpal".equals("Tejpal")%>

	<%
		System.out.println("a + b : " + result);
	%>

	<br> Result of a + b is :
	<%=addNuumbers(10, 20)%>


Search your query
	<form action="welcome.jsp" method="post">
		<input type="text" name="query"> 
		<input type="submit" value="go"><br />
	</form>

</body>
</html>