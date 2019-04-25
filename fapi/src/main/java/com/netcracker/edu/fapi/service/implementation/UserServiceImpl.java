package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public Page<User> getAllUsers(int page) {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(backendURL + "/api/users?page=" + page, RestPageImpl.class);
    }

    @Override
    public Page<User> getAllCompanies(int page) {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(backendURL + "/api/users/companies?page=" + page, RestPageImpl.class);
    }

    @Override
    public User getUserById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/users/" + id, User.class);
    }

    @Override
    public User findUserByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/users/login/" + login, User.class);
    }

    @Override
    public User findUserByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/users/email/" + email, User.class);
    }

    @Override
    public User saveUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendURL + "/api/users", user, User.class).getBody();
    }
}
