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
	
	<!-- The below syntax gets automatically add once loggedin 
	<input type="hidden" name="_csrf" value="8b68ac02-1244-4852-9828-8ded32dd86a5" /> -->
</body>
</html>