package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getAllUsers(int page, String filter);
    Page<User> getAllCompanies(int page);
    User getUserById(int id);
    User findUserByLogin(String login);
    User saveUser(User user);
    User findUserByEmail(String email);
}
