<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!-- Add tags for Security for User roles -->

<html>
<head>
	<title> Home Page For Spring Security</title>
</head>

<body>
	<h2> Welcome to the Spring Java Configuration(no xml) Home page</h2>
	
	<hr>
	<!-- display User name and Role -->
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	
	<security:authorize access="hasRole('MANAGER')">
	
	<!-- Add a link to point to /leaders ... this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		(Only for Manager peeps)
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	
	<!-- Add a link to point to /systems ... this is for the admins -->
	
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin peeps)
	</p>
	</security:authorize>
	
	<hr>
	
	<!-- Add a Logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>
	
	
	
</body>
</html>