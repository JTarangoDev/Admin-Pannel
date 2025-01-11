package dev.jtarango.customer_pannel.services;

import com.google.common.hash.Hashing;
import dev.jtarango.customer_pannel.models.User;
import dev.jtarango.customer_pannel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{


    private static final String SECRET_KEY = "f4uyd78ft3q4";

    @Autowired
    UserRepository repository;

    @Override
    public User getUser(Integer id) {
        Optional<User> user = repository.findById(id);

        return user.orElse(null);
        /*
        if (customer.isPresent()) {
            return customer.get();
        }

        return null;
         */
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        Iterable<User> users = repository.findAll();

        for(User user:users){
            list.add(user);
        }

        return list;
    }

    @Override
    public void removeUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        String hashPassword = Hashing.sha256().hashString(user.getPassword() + SECRET_KEY, StandardCharsets.UTF_8).toString();

        user.setPassword(hashPassword);
        repository.save(user);
    }

    @Override
    public void updateUser(Integer id, User updatedUser) {
        updatedUser.setId(id);
        repository.save(updatedUser);
    }

    @Override
    public List<User> searchUser(String email, String address) {
        return repository.findByEmailOrAddress(email, address);
    }
}
