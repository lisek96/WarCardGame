<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="welcome.css">
</head>
<body>
<div id="welcome">Witaj <c:out value="${sessionScope.user.login}"></c:out>!</div>
</body>
</html>
