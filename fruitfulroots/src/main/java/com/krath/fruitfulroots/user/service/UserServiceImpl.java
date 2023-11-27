package com.krath.fruitfulroots.user.service;

import com.krath.fruitfulroots.conf.encoder.FRPwEncoder;
import com.krath.fruitfulroots.user.entity.User;
import com.krath.fruitfulroots.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    private final FRPwEncoder pwEncoder;

    @Autowired
    public UserServiceImpl(FRPwEncoder pwEncoder){
        this.pwEncoder = pwEncoder;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String updateUser(User user) {
        //check if user exists with optional; if they exist update user else throw exception
        Optional<User> userOptional = userRepository.findById(user.getId());

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("USER_NOT_FOUND");
        }

        User updateUser = userOptional.get();
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        saveUser(updateUser);
        return "User updated successfully";

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(long id) {
        Optional<User> user = userRepository.findById(id);
        try {
            if (user.isPresent()) {
                userRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("USER_NOT_FOUND");
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> loginUser(User user) {
        User userCheck = userRepository.findByUsername(user.getUsername());
        Map<String, String> response = new HashMap<>();
        if (userCheck == null || !pwEncoder.matchPassword(user.getPassword(), userCheck.getPassword())) {
            response.put("error", "Invalid username or password");
        }
        //if password matches and user is not null
        response.put("message", "Login Successful");
        return ResponseEntity.ok(response);
    }

    @Override
    public String createUser(User userData) {
        if (userData.getPassword() == null || userData.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        //encode password and set the hashed password as the current password
        String encryptedPw = pwEncoder.encodePassword(userData.getPassword());
        userData.setPassword(encryptedPw);

        saveUser(userData);
        return "User created successfully";
    }

    @Override
    public Optional<User> findByUserId(long id) {
        return userRepository.findById(id);
    }
}
