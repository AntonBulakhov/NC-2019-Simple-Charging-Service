package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    Page<User> findAllUsers(Pageable pageable, Role role);
    Page<User> findAllCompanies(Pageable pageable, Role role);
    User findByLogin(String login);
    User findByEmail(String email);
    User save(User user);
    void delete(int id);
}
