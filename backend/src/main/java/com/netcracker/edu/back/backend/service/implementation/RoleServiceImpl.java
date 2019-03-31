package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.repository.RoleRepository;
import com.netcracker.edu.back.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return (List<Role>)roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return (Role)roleRepository.findByName(name);
    }
}
