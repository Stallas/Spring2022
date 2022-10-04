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
	
	<!-- Add a Logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>
	
	
	
</body>
</html>