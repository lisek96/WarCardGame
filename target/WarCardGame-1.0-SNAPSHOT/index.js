function noAcc1() {
    const noAccButton = document.getElementById("NoAcc");
    noAccButton.innerText = "Register";
}

function noAcc2() {
    const noAccButton = document.getElementById("NoAcc");
    noAccButton.innerText="No account?";
}

function noAcc3(){
    const registrationForm = document.getElementById("registrationForm");
    const loginForm = document.getElementById("loginForm");
    loginForm.style.display="none";
    registrationForm.style.display="block";
}

document.getElementById("NoAcc").onmouseenter = noAcc1;
document.getElementById("NoAcc").onmouseout = noAcc2;
document.getElementById("NoAcc").onclick = noAcc3;

function goBack1(){
    const goBackButton = document.getElementById("goBack");
    goBackButton.style.backgroundColor="red";
}
function goBack2(){
    const goBackButton = document.getElementById("goBack");
    goBackButton.style.backgroundColor="yellow";
}

function goBack3(){
    const registrationForm = document.getElementById("registrationForm");
    const loginForm = document.getElementById("loginForm");
    loginForm.style.display="block";
    registrationForm.style.display="none";
}

document.getElementById("goBack").onmouseenter = goBack1;
document.getElementById("goBack").onmouseout = goBack2;
document.getElementById("goBack").onclick = goBack3;


function postForm(){
    var data = new Object();


}
