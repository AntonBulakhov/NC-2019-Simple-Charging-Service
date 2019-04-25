package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.repository.UserRepository;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable, Role role) {
        return userRepository.findAllByRoleNotIn(pageable, role);
    }

    @Override
    public Page<User> findAllCompanies(Pageable pageable, Role role) {
        return userRepository.findAllByRoleIn(pageable, role);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
