function noAcc1() {
    const noAccButton = document.getElementById("NoAcc");
    noAccButton.innerText = "Register";
}

function noAcc2() {
    const noAccButton = document.getElementById("NoAcc");
    noAccButton.innerText="No account?";
}

document.getElementById("NoAcc").onmouseenter = noAcc1;
document.getElementById("NoAcc").onmouseout = noAcc2;

