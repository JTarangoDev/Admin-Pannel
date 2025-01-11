const addSubmit = async (e) => {
    e.preventDefault();

    let firstName = document.getElementById('FormFirstName').value;
    let lastName = document.getElementById('FormLastName').value;
    let address = document.getElementById('FormAddress').value;
    let email = document.getElementById('FormEmail').value;

    let customer = {
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "address": address
    }

    

    await create(customer)

    $('#addModal').modal('hide');
    e.target.reset();
}

const create = async (customer) => {

    let url = URL_SERVER + 'customer';

    let config = {
        method: 'POST',
        body: JSON.stringify(customer),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    };
    await fetch(url, config)


    

    renderCustomers();
}

const editSubmit = async (e) => {
    e.preventDefault();

    let id = document.getElementById('editFormId').value;
    let firstName = document.getElementById('editFormFirstName').value;
    let lastName = document.getElementById('editFormLastName').value;
    let address = document.getElementById('editFormAddress').value;
    let email = document.getElementById('editFormEmail').value;

    let customer = {
        "id": id,
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "address": address
    }

    

    await edit(customer)

    $('#editModal').modal('hide');
    e.target.reset();
}

const edit = async(customer) => {
    let url = URL_SERVER + 'customer/' + customer.id;

    let config = {
        method: 'PUT',
        body: JSON.stringify(customer),
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    };
    await fetch(url, config)

    renderCustomers();
}

