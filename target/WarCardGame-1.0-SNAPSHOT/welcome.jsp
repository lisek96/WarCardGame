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
<input class="info" id = "saveChanges" type="text" value=""/>
<input class="info" id = "range" type="text" value="Range from 1 to ? (your input)"/>
<input class="info" type="text" disabled/>
<div id="MyProfileSection">
    <div id="avatarDiv">
        <img width="300px" height="300px" src="avatars/rafal.jpg" id="avatar">
    </div>
    <div id="figures">
        <p id="login">Login:</p>
        <p id="email">Email:</p>
        <p id="ranking">Ranking:</p>
        <p id="matches">Matches:</p>
        <p id="wins">Wins:</p>
        <p id="loses">Loses:</p>
        <p id="winPercentage">Win percentage:</p>
    </div>
</div>

<div id="EditProfileSection">
    <div id="changeAvatar">
        <div id="changeAvatarResult">Result</div>
        <div id="avatarFirst">Upload your avatar (300x300)px:</div>
        <div><input type="file" name="file" id="file" /></div>
        <div><button id="sendAvatar">Upload avatar</button></div>
    </div>
    <div id="changeFigure">
        <div id="changeFigureResult">Result</div>
        <div id="figureFirst"><input type="text" name="figure" value="Input"/></div>
        <div><input type="text" name="confirm" value="Confirm"/></div>
        <div><input type="radio" id="changeLogin" name="figureType" value="Login"/>Login</div>
        <div><input type="radio" id="changePassword" name="figureType" value="Password"/>Password</div>
        <div><input type="radio" id="changeEmail" name="figureType" value="Email"/>Email</div>
        <div><button id="sendChangeFigure">Confirm change</button></div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/welcome.js"></script>
</body>
</html>
