const formUser = document.getElementById("formUser")
const txtName = document.getElementById("txtName")
const txtEmail = document.getElementById("txtEmail")
const txtPassword = document.getElementById("txtPassword")
const txtPassword2 = document.getElementById("txtPassword2")

formUser.addEventListener("submit", (E) => {

    if (txtPassword.value != txtPassword2.value) {
        console.log("passwords do not match")
        E.preventDefault()
        alert("Contraseñas diferentes")
    } else {
        console.log("passwords match");
    }

    if(validateEmail(txtEmail)){
        console.log("correo valido");
    }else{
        console.log("correo invalido");
        E.preventDefault()
    }

})

const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
}