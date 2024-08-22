package com.crud_application.controller;


import com.crud_application.httpRequests.UserRequest;
import com.crud_application.model.User;
import com.crud_application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/public/user/register")
    public ResponseEntity<User> registerUser(@RequestBody @Validated UserRequest userRequest) {
        User user = userService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/api/private/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/public/user/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            User user = userService.loginUser(username, password);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
        }
    }

    @PutMapping("/api/private/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Validated UserRequest userRequest) {
        try {
            User updatedUser = userService.updateUser(id, userRequest);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }
    }

    @GetMapping("/api/admin/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

