<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Account Setting</title>
</head>
<body>
<h2>Account Setting</h2>
	<sf:form method="POST" modelAttribute="user" action="/account">
		<fieldset>
			<legend>Profile</legend>
			<div>
				<label for="user_full_name">Full Name:</label>
				<sf:input path="fullName" size="15" id="user_full_name"/>
				<sf:errors path="fullName"/>
			</div>
			<div>
				<label for="user_email">Email:</label>
				<sf:input path="email" size="30" id="user_email"/>
				<sf:errors path="email"/>
			</div>
			<div>
				<label for="user_job">Job:</label>
				<sf:input path="job" size="30" id="user_job"/>
				<sf:errors path="job"/>
			</div>
		    <input type="submit" value="Save account">	
		</fieldset>
	</sf:form>
	<div>
		<h1>Authentication</h1>
		<div></div>
	</div>
</body>
</html>
