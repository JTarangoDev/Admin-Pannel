package dev.jtarango.customer_pannel.controllers;

import dev.jtarango.customer_pannel.models.User;
import dev.jtarango.customer_pannel.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService service;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return service.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void removeUser(@PathVariable Integer id){
        service.removeUser(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }


    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User updatedUser){
        service.updateUser(id, updatedUser);
    }

    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email, @RequestParam(name = "address", required = false) String address){
        return service.searchUser(email, address);
    }
}
