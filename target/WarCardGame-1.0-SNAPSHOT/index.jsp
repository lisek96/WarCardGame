<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="mainpage.css">
</head>
<body>
<form id="loginForm" action="/Login" method="post">
    <div><input class="formElements" type="text" name="login" value="Login"></div>
    <div><input class="formElements" type="password" name="password" value="password"></div>
    <div><input class="buttons" id="goButton" type="submit" value="Go!"></div>
    <div><button class="buttons" type="reset" id="NoAcc">No account?</button></div>
</form>

<form id="registrationForm" action="/Register" method="post">
    <div><input class="formElements" type="text" name="login" value="Login"></div>
    <div><input class="formElements" type="password" name="password" value="password"></div>
    <div><input class="formElements" type="text" name="email" value="email"></div>
    <div><input class="buttons" id="register" type="submit" value="Register!"></div>
    <div><button class="buttons" type="reset" id="goBack">go back</button></div>
</form>
<footer>WarCardGame</footer>
<script src="newLogin.js"></script>
</body>
</html>
