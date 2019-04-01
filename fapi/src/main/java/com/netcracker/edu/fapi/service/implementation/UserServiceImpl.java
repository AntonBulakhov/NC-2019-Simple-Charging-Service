package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Value("http://localhost:8081/")
    private String backendURL;

    @Override
    public User getUser() {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendURL + "/api/user/getuser", User.class);
        return user;
    }
}
