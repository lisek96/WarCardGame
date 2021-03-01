function sendAvatar () {
    let form = $('form')[0];
    let formData = new FormData(form);
    $.ajax({
        url : "/WarCardGame_war_exploded/upload",
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false
    });
    console.log("sent");
}
$("#sendAvatar").click(function (){
    sendAvatar();
});