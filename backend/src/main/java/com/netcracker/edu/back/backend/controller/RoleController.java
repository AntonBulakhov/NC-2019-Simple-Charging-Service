package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.repository.RoleRepository;
import com.netcracker.edu.back.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Role> getAllRoles(){
        return roleService.findAll();
    }
}
