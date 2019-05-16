package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${backend.server.url}")
    private String backendURL;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Override
    public User isBlocked(String login) {
        return findUserByLogin(login);
    }

    @Override
    public void blockUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendURL + "/api/users/block/id/" + id, User.class);
    }

    @Override
    public void unblockUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendURL + "/api/users/unblock/id/" + id, User.class);
    }

    @Override
    public Page<User> getAllUsers(int page, String filter) {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(backendURL + "/api/users?page=" + page + "&filter=" + filter, RestPageImpl.class);
    }

    @Override
    public Page<User> getAllCompanies(int page) {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(backendURL + "/api/users/companies?page=" + page, RestPageImpl.class);
    }

    @Override
    public User getUserById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/users/id/" + id, User.class);
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByLogin(s);
        return new  org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    @Override
    public User saveUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        user.setPassword(bCrypt.encode(user.getPassword()));
        return restTemplate.postForEntity(backendURL + "/api/users", user, User.class).getBody();
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName().toUpperCase()));
        return authorities;
    }
}
