const signUp = async () => {
    let firstName = document.getElementById('newUserFirstName').value;
    let lastName = document.getElementById('newUserLastName').value;
    let address = document.getElementById('newUserAddress').value;
    let email = document.getElementById('newUserEmail').value;
    let password = document.getElementById('newUserPassword').value;
    let repeatPassword = document.getElementById('newUserRepeatPassword').value;

    if (!password) {
        alert("Introduce a password")
    } else if (password !== repeatPassword ) {
        alert("Password do not match")
    } else {
        let user = {
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "address": address,
            "password": password
        }

        await create(user)
    }

}

const create = async (user) => {

    let url = URL_SERVER + 'auth/register';

    let config = {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    let response = await fetch(url, config);

    if (response.ok){
        window.location.href = "/login.html"
    } else {
        alert("Email already in use")
    }

    
}
