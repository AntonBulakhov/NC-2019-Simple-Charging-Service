package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
    Role findRoleByName(String name);
}
