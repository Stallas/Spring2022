<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Custom Login Page</title>
	<style>
		.failed {
			color: red;
		}
	</style>
</head>

<body>
<h3>Custom Login Page</h3>

<!-- Spring security filters will read the data(username and password) and authenticate the user and must POST the data-->

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

<!-- Failed login - Spring redirects to login page with ?error parameter and have to give custom error msg details (JSTL)
	 http://localhost:8080/spring-security-demo-03-custom-login-form/showMyLoginPage?error-->

		<c:if test="${param.error != null}">
			<i class="failed">Sorry! You entered invalid username/password.</i>
		</c:if>
		
		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login"/>
	</form:form>

</body>

</html>