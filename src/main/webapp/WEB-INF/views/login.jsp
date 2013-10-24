<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>User Login</title>
</head>
<body>
	<div align="center">
		<sf:form method="POST" modelAttribute="user" action="/login">
			<fieldset>
				<legend>Welcome</legend>
				<div>
					<label for="user_email">Login Id(Email):</label>
					<sf:input path="email" size="30" id="user_email" />
					<sf:errors path="email" />
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
