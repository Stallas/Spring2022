<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title> Home Page For Spring Security</title>
</head>

<body>
	<h2> Welcome to the Spring Java Configuration(no xml) Home page</h2>
	
	<!-- Add a Logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>
</body>
</html>