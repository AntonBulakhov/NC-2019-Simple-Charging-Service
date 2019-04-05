package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.repository.RoleRepository;
import com.netcracker.edu.back.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return (List<Role>)roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
