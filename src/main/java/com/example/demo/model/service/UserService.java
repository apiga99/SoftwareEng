package com.example.demo.model.service;

import com.example.demo.model.data.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User updateUser(User student);

    void deleteUserById(Long id);

    User findByEmail(String email);
}
