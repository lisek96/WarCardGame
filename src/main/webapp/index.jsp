<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div id="succRegInfo"><c:out value="${requestScope.succRegistrationAttempt}"></c:out></div>
<div class="fail"><c:out value="${requestScope.failRegistrationAttempt}"></c:out></div>
<div class="fail"><c:out value="${requestScope.loginAttemptInfo}"></c:out></div>
<form id="loginForm" action="Login" method="post">
    <div><input class="formElements" type="text" name="login" value="Login" required></div>
    <div><input class="formElements" type="password" name="password" value="password" required></div>
    <div><input class="buttons" id="goButton" type="submit" value="Go!"></div>
    <div><button class="buttons" type="reset" id="NoAcc">No account?</button></div>
</form>

<form id="registrationForm" action="Register" method="post">
    <div><input class="formElements" type="text" name="login" value="Login" required></div>
    <div><input class="formElements" type="password" name="password" value="password" required></div>
    <div><input class="formElements" type="text" name="email" value="email" required></div>
    <div><input class="buttons" id="register" type="submit" value="Register!"></div>
    <div><button class="buttons" type="reset" id="goBack">Go back</button></div>
</form>
<footer>WarCardGame</footer>
<script src="index.js"></script>
</body>
</html>
