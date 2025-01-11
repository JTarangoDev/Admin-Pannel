package dev.jtarango.customer_pannel.services;

import dev.jtarango.customer_pannel.models.User;

import java.util.List;

public interface IUserService {

    User getUser(Integer id);

    List<User> getAllUsers();

    void removeUser(Integer id);

    void addUser(User user);


    void updateUser(Integer id, User updatedUser);

    List<User> searchUser(String email, String address);
}
