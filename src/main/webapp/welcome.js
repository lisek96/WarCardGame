$("#play").click(function (){
    window.location.href="http://localhost:8080/WarCardGame_war_exploded/play"+"?cardsNumber="+checkCardsNumber();
})

function checkCardsNumber() {
    return document.getElementById("cardsNumber").value;
}

