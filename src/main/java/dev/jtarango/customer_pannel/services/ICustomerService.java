package dev.jtarango.customer_pannel.services;

import dev.jtarango.customer_pannel.models.Customer;

import java.util.List;

public interface ICustomerService {

    Customer getCustomer(Integer id);

    List<Customer> getAllCustomer();

    void removeCustomer(Integer id);

    void addCustomer(Customer customer);


    void updateCustomer(Integer id, Customer updatedCustomer);

    List<Customer> searchCustomer(String email, String address);
}

