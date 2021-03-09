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
    showLoading();
    const login = document.getElementById("playerLogin").value;
    console.log(login);
    $.get("http://localhost:8080/WarCardGame_war_exploded/profile/" + login, function (data) {
        const figures = data
        changeFigures(figures);
    }, "json")
        .fail(playerNotFound)
        .always(hideLoading());
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
        $("#avatar").attr("src", "avatars/" + login + ".jpg" + "");
    }
}

//avatar upload

function sendAvatar () {
    showLoading();
    let form = $('#form')[0];
    let formData = new FormData(form);
    $.ajax({
        url : "/WarCardGame_war_exploded/upload",
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false
    })
        .done(function (){
            hideLoading();
            showResultOfOperation("OK");
        })
        .fail(function (){
            hideLoading();
            showResultOfOperation("FAIL");
        });

}

$("#sendAvatar").click(sendAvatar);


$("#editProfile").click(editProfile);

function editProfile(){
    document.getElementById("MyProfileSection").style.display = "none";
    document.getElementById("EditProfileSection").style.display="block";
}

function hideLoading(){
    document.getElementById("loading").style.display="none";
}

function showLoading(){
    document.getElementById("loading").style.display="block";
}

function showResultOfOperation(result, failMessage){
    if(result==="OK") {
        document.getElementById("result").style.color = "limegreen";
        document.getElementById("result").innerText = "Success"
    }
    else if(result==="FAIL"){
        document.getElementById("result").style.color = "red";
        document.getElementById("result").innerText = "Error, " + failMessage;
    }
    document.getElementById("result").style.display="block";
}

function hideResultOfOperation(){
    document.getElementById("result").style.display="none";
}


