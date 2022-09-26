<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>
		<form:form action= "processForm" modelAttribute="student">
			First Name : <form:input path="firstName"/>
			<br><br>
			Last Name : <form:input path="lastName"/>
			<br><br>
			Country:
				 <form:select path="country">
<%-- 				 <form:options items="${student.countryOptions}"/> --%>
					<form:option value="Brazil" label="Brazil"/>
					<form:option value="Germany" label="Germany"/>
					<form:option value="India" label="India"/>
					<form:option value="USA" label="USA"/>
				</form:select>
			<br><br>
			Favourite Language:
					Java<form:radiobutton path="favouriteLanguage" value="Java"/>
					PHP<form:radiobutton path="favouriteLanguage" value="PHP"/>
					C#<form:radiobutton path="favouriteLanguage" value="C#"/>
					Ruby<form:radiobutton path="favouriteLanguage" value="RubyS"/>
			<br><br>
			Operating Systems:
					Linux<form:checkbox path="operatingSystems" value="Linux"/>
					Mac<form:checkbox path="operatingSystems" value="Mac"/>
					Windows<form:checkbox path="operatingSystems" value="Windows"/>	
					<br><br>		
			<input type="submit" value="Submit">
		</form:form>
</body>
</html>