<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div>
	<h1>Random number test:</h1>
	<div>
		<c:out value="${randomNumbers}" />
	</div>

	<form id="loginForm" action="/login" method="post">
		<div>
			<label for="username">User Name:</label> <input type="text"
				id="username" name="username" value="" />
		</div>
		<div>
			<label for="password">Password:   </label> <input type="password"
				id="password" name="password" />
		</div>

		<div>
			<input id="submit_btn" type="submit" value="Login" />
		</div>
	</form>
</div>