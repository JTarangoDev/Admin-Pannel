package dev.jtarango.customer_pannel.controllers;

import dev.jtarango.customer_pannel.models.Customer;
import dev.jtarango.customer_pannel.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private ICustomerService service;


    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return service.getCustomer(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return service.getAllCustomer();
    }

    @DeleteMapping("/customer/{id}")
    public void removeCustomer(@PathVariable Integer id){
        service.removeCustomer(id);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }


    @PutMapping("/customer/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer){
        service.updateCustomer(id, updatedCustomer);
    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(@RequestParam(name = "email", required = false) String email, @RequestParam(name = "address", required = false) String address){
        return service.searchCustomer(email, address);
    }

}
