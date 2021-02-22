<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/game.css">
</head>
<body>
<div id="player" class="playerUi">
    <div id="p1Login">defaultLogin</div>
    <div><img id="p1CurrentCard" alt="defaultMessage"/></div>
</div>
<div id="computer" class="playerUi">
    <div>Computer</div>
    <div><img id="p2CurrentCard" alt="defaultMessage"/></div>
</div>
<div id="playButton"><button>play</button></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/ajax.js"></script>
</body>
</html>
