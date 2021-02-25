<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/play.css">
</head>
<body>
<div id="player" class="playerUi">
    <div id="p1Login">defaultLogin</div>
    <div><img id="p1CurrentCard" src="image/default.jpg" alt="defaultMessage"/></div>
</div>
<div id="computer" class="playerUi">
    <div id="computerNickname">Computer</div>
    <div><img id="p2CurrentCard" src="image/JC.jpg" alt="defaultMessage"/></div>
</div>
<div id="playButtonDiv"><button id="playButton">play</button></div>
<div id="stake">Stake of the ongoing war</div>
<div id="warCards"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/play.js"></script>
</body>
</html>
