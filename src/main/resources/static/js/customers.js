let customerId = '';
let dataTable;

const getCustomers = async () => {
    let url = URL_SERVER  + 'customer';

    let config = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    };
    
    let response = await fetch(url, config);
    let json = await response.json();

    return json;
}

const initDataTable = () => {
    dataTable = $('#customersTable').DataTable({
        paging: true,
        searching: true,
        ordering: true,
        info: true,
        responsive: true,
        destroy: true
    });
};

const renderCustomers = async () => {
    const customers = await getCustomers();

    // Clean existent rows in DataTables
    if (dataTable) {
        dataTable.clear();
    }

    // Add rows directly to DataTable
    for (let customer of customers) {
        dataTable.row.add([
            customer.id,
            `${customer.firstName} ${customer.lastName}`,
            customer.address,
            customer.email,
            `
            <a href="#" data-toggle="modal" data-target="#editModal" onclick="setIdToEdit(${customer.id})" class="btn btn-primary btn-circle btn-sm">
                <i class="fas fa-edit"></i>
            </a>
            <a href="#" data-toggle="modal" data-target="#deleteModal" onclick="setIdToRemove(${customer.id})" class="btn btn-danger btn-circle btn-sm">
                <i class="fas fa-trash"></i>
            </a>`
        ]);
    }

    // Draw the table with the new data
    dataTable.draw();
};

const handleRemove = async (id) => {

        let url = URL_SERVER + 'customer/' + id;

        let config = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': sessionStorage.token
            }
        };
        await fetch(url, config)
    
        customerId = ''

        renderCustomers();
    
}

const setIdToRemove = (id) => {
    customerId = id
}

const setIdToEdit = (id) => {
    customerId = id

    setForm(id)
}

const setForm = async (id) => {

    let url = URL_SERVER + 'customer/' + id;
    let config = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.token
        }
    };
    let response = await fetch(url, config)
    let json = await response.json();

    document.getElementById('editFormId').value = json.id;
    document.getElementById('editFormFirstName').value = json.firstName;
    document.getElementById('editFormLastName').value = json.lastName;
    document.getElementById('editFormAddress').value = json.address;
    document.getElementById('editFormEmail').value = json.email;

}

const getHtmlRowCustomer = (customer) => {
    return `<tr>
                <td>${customer.id}</td>
                <td>${customer.firstName} ${customer.lastName}</td>
                <td>${customer.address}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="#" data-toggle="modal" data-target="#editModal" onclick="setIdToEdit(${customer.id})" class="btn btn-primary btn-circle btn-sm">
                        <i class="fas fa-edit"></i>
                    </a>

                    <a href="#" data-toggle="modal" data-target="#deleteModal" onclick="setIdToRemove(${customer.id})" class="btn btn-danger btn-circle btn-sm">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
            </tr>`
}

$(document).ready(async () => {
    initDataTable(); // Initialize DataTables
    renderCustomers();
});