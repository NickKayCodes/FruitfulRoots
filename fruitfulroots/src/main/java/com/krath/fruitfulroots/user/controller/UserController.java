package com.krath.fruitfulroots.user.controller;

import com.krath.fruitfulroots.user.entity.User;
import com.krath.fruitfulroots.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userData) {
        ResponseEntity<String> loginResult = userService.loginUser(userData);

        if (loginResult.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User userData) {

        try {
            String registerCheck = userService.createUser(userData);
            return ResponseEntity.ok("User Registration Successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            String updateResult = userService.updateUser(user);
            return ResponseEntity.ok(updateResult);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/findUserByEmail")
    public ResponseEntity<User> findUserByEmail(@RequestBody String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rmUser")
    public ResponseEntity<String> deleteUser(@RequestBody long id) {
        Optional<User> user = userService.findByUserId(id);
        if (user.isPresent()) {
            userService.removeUser(id);
            return ResponseEntity.ok("User removed");
        } else {
            return ResponseEntity.internalServerError().body("User Does Not Exist");
        }
    }
}