function player(name, cards, amountOfCards){
    this.name=name;
    this.cards=cards;
    this.amountOfCardss=amountOfCards;
}


function addNewManufacturer() {
    var sendInfo = "witam";


    console.log("xx");

    $.ajax({
        type: "POST",
        url: "/WarCardGame_war_exploded/deal",
        dataType: "text",
        data: sendInfo
    });
}

function callback(response) {
    let shuffled = `__`;
    shuffled = response;
    let cardsAndLogin = shuffled.split("\r\n");
    let login=cardsAndLogin[1];
    let cards=cardsAndLogin[0];
    let cardsArray = cards.split(" ");
    console.log(shuffled);
    console.log(login);
    console.log(cards);
    console.log(cardsArray);
    $("#test").text(shuffled);
}
function getShuffled(){
    $.get("/WarCardGame_war_exploded/deal", function (data){
        callback(data)}, "text")
        .done(function(data) {
            callback(data)
        })
        .fail(function() {
            alert( "error" );
        })
        .always(function() {
            alert( "finished" );
        });
    };

getShuffled();

function xx () {
    window.location.href = "http://www.gazeta.pl";
}

$("#xx").addEventListener("click", xx);





