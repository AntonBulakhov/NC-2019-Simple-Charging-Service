package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String login);
    User findByEmail(String email);
    User save(User user);
    void delete(long id);
}
