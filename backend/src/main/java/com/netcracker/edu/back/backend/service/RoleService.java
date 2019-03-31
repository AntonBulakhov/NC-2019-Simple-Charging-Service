package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findByName(String name);
}
