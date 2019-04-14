package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.User;

public interface UserService {
    User getUserByLogin(String login);
    User saveUser(User user);
}
