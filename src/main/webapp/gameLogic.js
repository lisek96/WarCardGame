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

function spawnCards(){
    let cards = new Array();
    let values = ['2','3','4','5','6','7','8','9','10','J','D','K','A'];
    let colors = ['C', 'D', 'H', 'S'];

    for(let i=0; i<colors.length; i++){
        for(let j=0; j<values.length; j++){
            cards.push(new card(j, values[j] + colors[i], values[j] + colors[i]+'.jpg'));ej
        }
    }
    return cards;
}

function game(player1, player2, warCards){
    this.player1=player1;
    this.player2=player2;
    this.warCards=warCards;
}

var player1 = new player("vv", "bb")
var player2 = new player("George", )