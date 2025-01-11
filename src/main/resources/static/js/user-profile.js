const userData = JSON.parse(sessionStorage.getItem('user'));

document.getElementById('userName').innerHTML = `${userData.firstName} ${userData.lastName}`