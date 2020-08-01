<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/students/update" method="post" modelAttribute="student">
		
		<%--   <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="firstName"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>  --%>
		
		<form:input type="hidden" path="id" class="form-control"></form:input> <br>
		<label  for="firstName">First name:</label>
		<form:input type="text" path="firstName" class="form-control" placeholder="firstName" autofocus="true"></form:input> <br>
		
		<label  for="lastName">Last name:</label>
		<form:input type="text" path="lastName" class="form-control" placeholder="lname" autofocus="true"></form:input><br>
		
		<label  for="rollNo">Roll:</label>
		<form:input type="text" path="rollNo" class="form-control" placeholder="rollNo" autofocus="true"></form:input><br>
		
		<label  for="mobile">Mobile:</label>
		<form:input type="text" path="mobile" class="form-control" placeholder="mobile" autofocus="true"></form:input><br>
		
		<label  for="course">Course:</label>
		<form:input type="text" path="course" class="form-control" placeholder="course" autofocus="true"></form:input> <br>
		
		<label  for="userName">User Name</label>
		<form:input type="text" path="userName" class="form-control" placeholder="userName" autofocus="true"></form:input> <br>
		
		<label  for="password">Password</label>
		<form:input type="text" path="password" class="form-control" placeholder="password" autofocus="true"></form:input> <br>
		
		<label  for="confirmPassword">Confirm password</label>
		<form:input type="text" path="confirmPassword" class="form-control" placeholder="confirmPassword" autofocus="true"></form:input> <br>
		
		
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>