const login = async () => {
    let url = URL_SERVER  + 'auth/login';

    let email = document.getElementById("loginEmailForm").value;
    let password = document.getElementById("loginPasswordForm").value;

    let data = {
        "email": email,
        "password": password
    }

    let config = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token,
        },
        body: JSON.stringify(data)
    }
    let response = await fetch(url, config);
    let json = await response.json();
    
    if (response.ok){
        sessionStorage.setItem('token', json.token);
        const {token, ...loggedUser} = json;
        sessionStorage.setItem('user', JSON.stringify(loggedUser));
        window.location.href = "/index.html"
    }
    
}

const logout = async () => {
    sessionStorage.clear();
    window.location.href = "/login.html"
}
