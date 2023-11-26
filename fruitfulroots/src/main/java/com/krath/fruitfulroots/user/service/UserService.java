package com.krath.fruitfulroots.user.service;

import com.krath.fruitfulroots.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void saveUser(User user);

    User getUserByEmail(String email);

    String updateUser(User user);

    List<User> getAllUsers();

    void removeUser(long id); // May c

    ResponseEntity<String> loginUser(User user);

    String createUser(User userData);

    Optional<User> findByUserId(long id);
}

