package dev.jtarango.customer_pannel.services;

import dev.jtarango.customer_pannel.models.Customer;
import dev.jtarango.customer_pannel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository repository;


    public Customer getCustomer(Integer id){
        Optional<Customer> customer = repository.findById(id);

        return customer.orElse(null);
        /*
        if (customer.isPresent()) {
            return customer.get();
        }

        return null;
         */
    }

    public List<Customer> getAllCustomer(){
        List<Customer> list = new ArrayList<>();

        Iterable<Customer> customers = repository.findAll();

        for(Customer customer:customers){
            list.add(customer);
        }

        return list;
    }

    public void removeCustomer(Integer id){
        repository.deleteById(id);
    }

    public void addCustomer(Customer customer){
        repository.save(customer);
    }


    public void updateCustomer(Integer id, Customer updatedCustomer){
        updatedCustomer.setId(id);
        repository.save(updatedCustomer);
    }

    public List<Customer> searchCustomer(String email, String address){

        return repository.findByEmailOrAddress(email, address);
    }
}
