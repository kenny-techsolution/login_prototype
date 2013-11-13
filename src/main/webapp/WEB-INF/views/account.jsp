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
				<sf:input path="username" size="15" id="user_full_name"/>
				<sf:errors path="username"/>
			</div>
			<div>
				<label for="user_email">Email:</label>
				<sf:input path="email" size="30" id="user_email"/>
				<sf:errors path="email"/>
			</div>
		    <input type="submit" value="Save account">	
		</fieldset>
	</sf:form>
	<div>
		<h1>Authentication</h1>
		<div></div>
	</div>
	<form method="POST" action="/signin/facebook/">
	   <input type="submit" value="Facebook signin">
	</form>
	<form method="POST" action="/connect/facebook/">
       <input type="submit" value="Facebook connect">
    </form>
    <a href="/connect">connect</a>
    <a href="/logout">Logout</a>
</body>
</html>
