function player(name, cards, currentCardIndex){
    this.name=name;
    this.cards=cards;
    this.currentCardIndex=currentCardIndex;
}

function card(value, symbol, jpg){
    this.value=value;
    this.symbol=symbol;
    this.jpg=jpg;
}



function game(player1, player2, warCards){
    this.player1=player1;
    this.player2=player2;
    this.warCards=warCards;
}

var player1 = new player("vv", "bb")
var player2 = new player("George", )