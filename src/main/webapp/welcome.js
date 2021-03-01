$("#play").click(function (){
    window.location.href="http://localhost:8080/WarCardGame_war_exploded/play"+"?cardsNumber="+checkCardsNumber();
})

function checkCardsNumber() {
    return document.getElementById("cardsNumber").value;
}

$("#myProfile").click(function (){
    myProfile();
})

$(document).ready(myProfile());

function myProfile(){
    $.get("http://localhost:8080/WarCardGame_war_exploded/profile/", function (data){
        const stats = data
        changeFigures(stats);
    }, "json");
}

function changeFigures(stats){
    changeImage(stats.login);
    $("#login").text("Login: " + stats.login);
    $("#email").text("Email: " + stats.email);
    $("#ranking").text("Ranking: " + stats.ranking);
    $("#matches").text("Matches: " + stats.matches);
    $("#wins").text("Wins: " + stats.wins);
    $("#loses").text("Loses: " + stats.loses);
    $("#winPercentage").text("Win percentage: " + stats.winPercentage);
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



