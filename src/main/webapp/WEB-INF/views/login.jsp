<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>User Login</title>
</head>
<body>
	<div align="center">
		<sf:form method="POST" modelAttribute="account" action="/login">
			<fieldset>
				<legend>Welcome</legend>
				<div>
					<label for="userid">Login Id:</label>
					<sf:input path="userid" size="30" id="user_email" />
					<sf:errors path="userid" />
				</div>
				<div>
					<label for="password">Password:</label>
					<sf:input path="password" size="30" id="password" />
					<sf:errors path="password" />
				</div>
				<input type="submit" value="Login">
			</fieldset>
		</sf:form>
	</div>
</body>
</html>
