<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="welcome.css">
</head>
<body>
<div id="welcome">Welcome <c:out value="${sessionScope.user.login}"></c:out>!</div>
<button id="play" class="buttons">Play</button>
<button id="findPlayer" class="buttons">Find player</button>
<button id="editProfile" class="buttons">Edit profile</button>
<button id="checkRanking" class="buttons">Check rankings</button>
<button id="myProfile" class="buttons">My profile</button>
<input class="info" id = "cardsNumber" type="text" value="How many cards per player?"/>
<input class="info" id = "playerLogin" type="text" value="Pass player login"/>
<input class="info" id = "saveChanges" type="text" value="Save changes"/>
<input class="info" id = "range" type="text" value="Range from 1 to ? (your input)"/>
<input class="info" type="text" disabled/>
<div id="editProfileForm"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/welcome.js"></script>
</body>
</html>
