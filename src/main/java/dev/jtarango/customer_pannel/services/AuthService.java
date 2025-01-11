package dev.jtarango.customer_pannel.services;

import com.google.common.hash.Hashing;
import dev.jtarango.customer_pannel.models.User;
import dev.jtarango.customer_pannel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AuthService implements IAuthService{

    private static final String SECRET_KEY = "f4uyd78ft3q4";

    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String email, String password) {

        String hashPassword = Hashing.sha256().hashString(password + SECRET_KEY, StandardCharsets.UTF_8).toString();

        List<User> result = userRepository.findByEmailAndPassword(email, hashPassword);

        if (result.isEmpty()){
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public ResponseEntity<Object> register(User user) {
        List<User> result = userRepository.findByEmail(user.getEmail());

        if (result.isEmpty()){
            String hashPassword = Hashing.sha256().hashString(user.getPassword() + SECRET_KEY, StandardCharsets.UTF_8).toString();

            user.setPassword(hashPassword);
            userRepository.save(user);
            return ResponseEntity.ok("register successfull");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
    }
}
