function addNewManufacturer() {
    var sendInfo = "witam";


    console.log("xx");

    $.ajax({
        type: "POST",
        url: "/WarCardGame_war_exploded/ajax",
        dataType: "text",
        data: sendInfo
    });
}

document.getElementById("xx").addEventListener("click", addNewManufacturer);