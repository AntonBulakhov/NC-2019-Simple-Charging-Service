package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User getUserById(int id);
    User findUserByLogin(String login);
    User saveUser(User user);
    User findUserByEmail(String email);
}
