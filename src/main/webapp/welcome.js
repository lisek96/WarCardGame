$("#play").click(function (){
    window.location.href="http://localhost:8080/WarCardGame_war_exploded/play"+"?cardsNumber="+checkCardsNumber();
})

function checkCardsNumber() {
    return document.getElementById("cardsNumber").value;
}

$("#myProfile").click(function (){
    myProfile();
})

$("#findPlayer").click(findPlayer);

$(document).ready(myProfile());

function myProfile(){
    $.get("http://localhost:8080/WarCardGame_war_exploded/profile/", function (data){
        const figures = data
        changeFigures(figures);
    }, "json");
}

function findPlayer() {
    const login = document.getElementById("playerLogin").value;
    console.log(login);
    $.get("http://localhost:8080/WarCardGame_war_exploded/profile/" + login, function (data) {
        const figures = data
        changeFigures(figures);
    }, "json")
        .fail(playerNotFound);
}

function playerNotFound() {
    changeImage("usernotfound");
    document.getElementById("figures").style.display = "none";
}


$("#changeAvatarResult").hide();
$("#changeFigureResult").hide();

function showAvatarResult(){
    $("#changeAvatarResult").show();
    document.getElementById("avatarFirst").style.padding="0px";
}

function showFigureResult(){
    $("#changeFigureResult").show();
    document.getElementById("figureFirst").style.padding="0px";
}

function hideAvatarResult(){
    $("#changeAvatarResult").hide();
    document.getElementById("avatarFirst").style.padding="40px";
}

function hideFigureResult(){
    $("#changeFigureResult").hide();
    document.getElementById("figureFirst").style.padding="20px";
}

function changeFigures(figures){
    changeImage(figures.login);
    $("#login").text("Login: " + figures.login);
    $("#email").text("Email: " + figures.email);
    $("#ranking").text("Ranking: " + figures.ranking);
    $("#matches").text("Matches: " + figures.matches);
    $("#wins").text("Wins: " + figures.wins);
    $("#loses").text("Loses: " + figures.loses);
    $("#winPercentage").text("Win percentage: " + figures.winPercentage);
    document.getElementById("figures").style.display = "inline-block";
    document.getElementById("EditProfileSection").style.display="none";
    document.getElementById("MyProfileSection").style.display = "block"
}

function changeImage(login){
    let image = new Image();
    image.src = "avatars/" + login + ".jpg";
    image.onerror = function (){
        $("#avatar").attr("src", "avatars/default.jpg");
    }
    image.onload = function () {
        $("#avatar").attr("src", "avatars/" + login + ".jpg");
    }
}

//avatar upload

function sendAvatar () {
    let form = $('form')[0];
    let formData = new FormData(form);
    $.ajax({
        url : "/WarCardGame_war_exploded/upload",
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false
    });
    console.log("sent");
}

$("#sendAvatar").click(sendAvatar());


$("#editProfile").click(editProfile);

function editProfile(){
    document.getElementById("MyProfileSection").style.display = "none";
    document.getElementById("EditProfileSection").style.display="block";
}


