package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public Set<Role> getAllRoles(){
        return (Set<Role>)roleRepository.findAll();
    }
}
