package dev.jtarango.customer_pannel.services;

import dev.jtarango.customer_pannel.models.User;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    User login(String email, String password);

    ResponseEntity<Object> register(User user);
}
