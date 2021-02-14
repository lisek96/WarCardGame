

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="mainpage.css">
</head>
<body>
<div id="space"></div>
<div id="InfoForLoggedUser"><%=request.getSession().getAttribute("User")%></div>
<div id="welcome">
    <form action="controller.Login" method="post">
        <span>Login</span><input type="text" name="username">
        <br><br>
        <span>Password</span><input type="password" name="password">
        <br><br>
        <input id="goButton" type="submit" name="loginButton" value="Go!">
    </form>
    <button id="GoRegisterButton">No account?</button>
</div>
<div id="registration">
    <form action="Registration" method="post">
        <span>Login</span><input type="text" name="username">
        <br><br>
        <span>Password</span><input type="password" name="password">
        <br><br>
        <span>Email</span><input type="text" name="email">
        <br><br>
        <input id="registerButton" type="submit" name="registerButton" value="Register!">
    </form>
    <button id="backbutton">Back</button>
</div>
<script src="test.js"></script>
</body>
</html>
