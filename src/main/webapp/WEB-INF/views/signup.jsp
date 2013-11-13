
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>User Sign Up</title>
</head>
<body>
    <div align="center">
        <sf:form method="POST" modelAttribute="user" action="/signup">
            <fieldset>
                <legend>Sign Up</legend>
                <div>
                    <label for="username">Username:</label>
                    <sf:input path="username" size="30" id="username" />
                    <sf:errors path="username" />
                </div>
                <div>
                    <label for="email">Email:</label>
                    <sf:input path="email" size="30" id="email" />
                    <sf:errors path="email" />
                </div>
                <div>
                    <label for="password">Password:</label>
                    <sf:input path="password" size="30" id="password" />
                    <sf:errors path="password" />
                </div>
                <input type="submit" value="Sign up">
            </fieldset>
        </sf:form>
    </div>
</body>
</html>