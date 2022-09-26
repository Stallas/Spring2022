<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
			<title> Customer Confirmation</title>
	</head>
	<body>
			The Customer is confirmed : ${customer.firstName} ${customer.lastName} 
			${customer.freePasses}
			 ${customer.postalCode}
			  ${customer.courseCode}
	</body>
</html>