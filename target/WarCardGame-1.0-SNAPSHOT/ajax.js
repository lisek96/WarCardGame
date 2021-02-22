function player(name, cards, amountOfCards, currentCardIndex){
    this.name=name;
    this.cards=cards;
    this.amountOfCardss=amountOfCards;
    this.currentCardIndex=currentCardIndex;
}

function card(value, symbol, jpg){
    this.value=value;
    this.symbol=symbol;
    this.jpg=jpg;
}


function showCards(){
    for(let i=0; i<cards.length; i++){
        const newImg = document.createElement("img");
        newImg.src=cards[i].jpg;
        document.body.appendChild(newImg);
    }
}

function spawnCards(){
    let cards = new Array();
    let values = ['2','3','4','5','6','7','8','9','10','J','Q','K','A'];
    let colors = ['C', 'D', 'H', 'S'];

    for(let i=0; i<colors.length; i++){
        for(let j=0; j<values.length; j++){
            cards.push(new card(j, values[j] + colors[i], 'image/'+values[j] + colors[i]+'.jpg'));
        }
    }
    return cards;
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
    let orderLogin = `__`;
    orderLogin = response;
    let cardsAndLogin = orderLogin.split("\r\n");
    let login=cardsAndLogin[1];
    let cards=cardsAndLogin[0];
    let order = cards.split(" ");
    player1.name=login;
    dealCards(order);
    prepareUIs();
}
function getShuffled(){
    $.get("/WarCardGame_war_exploded/deal", function (data){
        callback(data)}, "text")
        .done(function(data) {
        })
        .fail(function() {
            alert( "error" );
        })
        .always(function() {
            alert( "finished" );
        });
    };

let cards = spawnCards();
let player1 = new player("", new Array(), 26, 25);
let computer = new player("Computer", new Array(), 26,25);

getShuffled();

function dealCards(order){
    for(let i=0; i<order.length; i++){
        if(i%2===0)  player1.cards.push(cards[order[i]]);
        else computer.cards.push(cards[order[i]]);
    }
}

function prepareUIs(){
    console.log(player1.cards);
    console.log(computer.cards);
    $("#p1Login").text(player1.name);
    console.log(player1.cards[player1.currentCardIndex].jpg)
    $("#p1CurrentCard").attr("src",player1.cards[player1.currentCardIndex].jpg);
    $("#p2CurrentCard").attr("src",computer.cards[computer.currentCardIndex].jpg);
    $("#play").click(play);
}

function play(){
    console.log("play")
}






function xx () {
    window.location.href = "http://www.gazeta.pl";
}




