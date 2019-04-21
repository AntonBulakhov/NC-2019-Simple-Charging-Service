package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    List<User> findAll();
    User findByLogin(String login);
    User findByEmail(String email);
    User save(User user);
    void delete(int id);
}
