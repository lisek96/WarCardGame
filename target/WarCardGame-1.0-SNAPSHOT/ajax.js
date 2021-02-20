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

function get(){
    return $.get("/WarCardGame_war_exploded/ajax", function (data){
        $('#xx').html(data);
    }, "text");
}

document.getElementById("xx").addEventListener("click", addNewManufacturer);
get();



