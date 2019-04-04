package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendURL;

    public User getUserByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendURL + "/api/user/login/" + login, User.class);
        return user;
    }
}
