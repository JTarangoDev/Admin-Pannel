package dev.jtarango.customer_pannel.controllers;

import dev.jtarango.customer_pannel.dto.RequestLogin;
import dev.jtarango.customer_pannel.models.User;
import dev.jtarango.customer_pannel.services.IAuthService;
import dev.jtarango.customer_pannel.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    IAuthService authService;

    @PostMapping("/auth/login")
    public Map<String, String> login(@RequestBody RequestLogin request) {
        Map<String, String> loggedUser = new HashMap<>();

        String email = request.getEmail();
        String password = request.getPassword();

        User user = authService.login(email, password);

        String token = JwtUtil.generateToken(user);

        loggedUser.put("token", token);
        loggedUser.put("firstName", user.getFirstName());
        loggedUser.put("lastName", user.getLastName());

        return loggedUser;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        return authService.register(user);
    }
}
