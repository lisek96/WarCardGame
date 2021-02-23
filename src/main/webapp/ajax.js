// test dla wojny jak jest mniej niz 3 karty, np rzucamy 1, jest remis wiec co robimy albo rzucimy 1 rzucimy 2 musimy rzucic 3 to ta 2 musi sie odwrocic


function Player(name, cards, amountOfCards, currentCardIndex) {
    this.name = name;
    this.cards = cards;
    this.amountOfCardss = amountOfCards;
    this.currentCardIndex = currentCardIndex;
}


function Card(value, symbol, jpg, jpgSmall) {
    this.value = value;
    this.symbol = symbol;
    this.jpg = jpg;
    this.jpgSmall = jpgSmall;
}

function spawnCards() {
    let cards = new Array();
    let values = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    let colors = ['C', 'D', 'H', 'S'];

    for (let i = 0; i < colors.length; i++) {
        for (let j = 0; j < values.length; j++) {
            cards.push(new Card(j, values[j] + colors[i], 'image/' + values[j] + colors[i] + '.jpg', 'imageSmall/' + values[j] + colors[i] + '.jpg'));
        }
    }
    return cards;
}

function setAmountOfStartingCards(amount) {
    let popCount = 25 - amount;
    for (let i = 0; i < popCount; i++) {
        player.cards.pop();
        computer.cards.pop();
    }
    player.currentCardIndex -= popCount;
    computer.currentCardIndex -= popCount;

}

let warCards = new Array();
let cards = spawnCards();
let player = new Player("", new Array(), 26, 25);
let computer = new Player("Computer", new Array(), 26, 25);


function showWarCards() {
    for (let i = warCards.length-4; i < warCards.length; i++) {
        const newImg = document.createElement("img");
        newImg.src = warCards[i].jpgSmall;
        newImg.style.marginLeft = "5px";
        document.getElementById("warCards").appendChild(newImg);
    }
}

function deleteWarCards() {
    warCards = new Array();
    let wardCardDiv = document.getElementById("warCards");
    while (wardCardDiv.firstChild) {
        wardCardDiv.removeChild(wardCardDiv.firstChild);
    }
}

function postMethodExample() {
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
    let orderAndLogin = orderLogin.split("\r\n");
    let login = orderAndLogin[1];
    let orderString = orderAndLogin[0];
    let orderArray = orderString.split(" ");
    player.name = login;
    dealCards(orderArray);
    console.log(cards);
    player.cards[25]=cards[1];
    computer.cards[25]=cards[1];
    player.cards[23]=cards[1];
    computer.cards[23]=cards[1];
    prepareUIs();
}

function getShuffled() {
    $.get("/WarCardGame_war_exploded/deal", function (data) {
        callback(data)
    }, "text")
        .done(function (data) {
        })
        .fail(function () {
            alert("error");
        })
        .always(function () {
        });
};


getShuffled();

function dealCards(order) {
    for (let i = 0; i < order.length - 1; i++) {
        if (i % 2 === 0) player.cards.push(cards[order[i]]);
        else computer.cards.push(cards[order[i]]);
    }
}

function prepareUIs() {
    console.log(player.cards);
    console.log(computer.cards);
    $("#p1Login").text(player.name);
    console.log(player.cards[player.currentCardIndex].jpg)
    $("#p1CurrentCard").attr("src", player.cards[player.currentCardIndex].jpg);
    $("#p2CurrentCard").attr("src", computer.cards[computer.currentCardIndex].jpg);
    $("#playButton").click(play);
}

function play() {
    let playerCard = player.cards.pop();
    let computerCard = computer.cards.pop();
    if (playerCard === undefined) {
        console.log("playerCardEnd");
        return;
    }
    if (computerCard === undefined) {
        console.log("computerCardEnd");
        return;
    }

    if (playerCard.value === computerCard.value) {
        console.log("REMIS");
        let playerHostage = player.cards.pop();
        let computerHostage = computer.cards.pop();
        player.currentCardIndex -= 2;
        computer.currentCardIndex -= 2;
        console.log(player.cards[player.currentCardIndex]);
        console.log(computer.cards[computer.currentCardIndex]);
        console.log(player.cards);
        console.log(computer.cards);
        console.log(player.currentCardIndex);
        console.log(computer.currentCardIndex);
        warCards.push(playerHostage, computerHostage);
        warCards.push(playerCard, computerCard);
        reloadCurrentCards();
        showWarCards();
    } else {
        let winner = playerCard.value > computerCard.value ? player : computer;
        if (playerCard.value > computerCard.value) {
            player.cards.unshift(playerCard, computerCard);
            player.currentCardIndex++;
            computer.currentCardIndex--;
        } else if (playerCard.value < computerCard.value) {
            computer.cards.unshift(playerCard, computerCard);
            computer.currentCardIndex++;
            player.currentCardIndex--;
        }

        if (warCards.length !== 0) {
            let count = warCards.length;
            winner.currentCardIndex += count;
            pushWarCardsToWinner(winner);
            deleteWarCards()
        }
        reloadCurrentCards();
    }

}


function pushWarCardsToWinner(winner) {
    warCards.forEach(function (item, index, array) {
        winner.cards.unshift(item);
    })
}


function reloadCurrentCards() {
    $("#p1CurrentCard").attr("src", player.cards[player.currentCardIndex].jpg + "");
    $("#p2CurrentCard").attr("src", computer.cards[computer.currentCardIndex].jpg + "");
}

function xx() {
    window.location.href = "http://www.gazeta.pl";
}