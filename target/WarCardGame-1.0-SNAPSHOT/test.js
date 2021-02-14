let addActionListeners = () => {
    document.getElementById("GoRegisterButton").addEventListener("mouseenter", function () {
        this.textContent = "Click to register!";
    });
    document.getElementById("GoRegisterButton").addEventListener("mouseout", function () {
        this.textContent = "No account?"
    });
    document.getElementById("GoRegisterButton").addEventListener("click", function () {
        document.getElementById("welcome").style.display = "none";
        document.getElementById("registration").style.display = "block"
    });
    document.getElementById("backbutton").addEventListener("click", function () {
        document.getElementById("welcome").style.display = "block";
        document.getElementById("registration").style.display = "none";
    });
}

let checkIfFailedLogin = () => {
    if (cookieExists("loginInfo")) {
        document.getElementById("welcome").setAttribute("style", "height:250")
        let newNode = document.createElement("div");
        newNode.id = "failLoginInfo";
        newNode.innerHTML = "Login attempt has failed, try again"
        document.getElementById("welcome").append(newNode);
    }
}

let cookieExists = (cookieName) => {
    let cookies = document.cookie;
    let cookiesArray = cookies.split(";");
    let cookieExists = false;
    for (let i = 0; i < cookiesArray.length; i++) {
        if (cookiesArray[i].startsWith(cookieName)) {
            cookieExists = true;
        }

        return cookieExists;
    }
}

let checkCertainCookieValue = (cookieName) =>{

}


checkIfFailedLogin();
addActionListeners();
