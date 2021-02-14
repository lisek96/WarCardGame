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
    <div><button class="buttons" id="NoAcc">No account?</button></div>
</form>
<footer>WarCardGame</footer>
<script src="newLogin.js"></script>
</body>
</html>
